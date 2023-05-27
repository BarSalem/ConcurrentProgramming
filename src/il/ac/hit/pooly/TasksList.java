package il.ac.hit.pooly;
import java.util.concurrent.PriorityBlockingQueue;

public class TasksList{
    private PriorityBlockingQueue<Task> listOfTasks;

    public TasksList() {
        this.listOfTasks = new PriorityBlockingQueue<>();
    }

    public Task getTask(){
        try {
            return this.listOfTasks.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void printTaskHighestPriority(){
        if (this.listOfTasks.size()>0){
            System.out.println(this.listOfTasks.element().getPriority());
        }
    }

    public void addTask(Task task) {
        this.listOfTasks.put(task);
    }
}
