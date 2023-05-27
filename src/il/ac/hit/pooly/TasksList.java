package il.ac.hit.pooly;
import java.util.concurrent.PriorityBlockingQueue;

public class TasksList{
    private PriorityBlockingQueue<Task> listOfTasks;

    public TasksList() {
        this.setListOfTasks(new PriorityBlockingQueue<>());
    }

    public Task getTask(){
        try {
            return this.listOfTasks.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public PriorityBlockingQueue<Task> getListOfTasks() {
        return listOfTasks;
    }

    public void setListOfTasks(PriorityBlockingQueue<Task> listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    public void printTaskHighestPriority(){
        if (this.listOfTasks.size()>0){
            System.out.println(this.listOfTasks.element().getPriority());
        }
    }

    @Override
    public String toString() {
        return "List of tasks:\n" + listOfTasks;
    }

    public void addTask(Task task) {
        this.listOfTasks.put(task);
    }

}
