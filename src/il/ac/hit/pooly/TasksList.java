package il.ac.hit.pooly;

import java.util.ArrayList;
import java.util.List;

public class TasksList{
    private List<Task> listOfTasks;

    public TasksList() {
        this.listOfTasks = new ArrayList<>();
    }

    public synchronized Task getTask(){
        return this.listOfTasks.remove(this.listOfTasks.size()-1);
    }

    public int getListLength(){
        return this.listOfTasks.size();
    }

    private void addAndSortListOfTasks(Task task){
        if (this.listOfTasks.size() == 0) this.listOfTasks.add(task);
        else {
            for (Task obj : this.listOfTasks) {
                if (task.getPriority() <= obj.getPriority()) {
                    int index = listOfTasks.indexOf(obj);
                    this.listOfTasks.add(index, task);
                    break;
                }
            }
        }
    }

    public synchronized void addTask(Task task) {
        this.addAndSortListOfTasks(task);
        if (this.getListLength() == 1) notifyAll();
    }
}
