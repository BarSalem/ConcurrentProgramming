package il.ac.hit.pooly;
import java.util.concurrent.PriorityBlockingQueue;

public class TasksList{ //Redundant?
    private PriorityBlockingQueue<Task> listOfTasks; //should be an instance of BlockingQueue

    public TasksList() {
        this.listOfTasks = new PriorityBlockingQueue<>();
    } //Add type: <Task>

    public Task getTask(){
        try {
            return this.listOfTasks.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void printTaskHighestPriority(){ //don't forget to delete
        if (this.listOfTasks.size()>0){
            System.out.println(this.listOfTasks.element().getPriority());
        }
    }

    public void addTask(Task task) { //should validate task?
        this.listOfTasks.put(task);
    }
}
