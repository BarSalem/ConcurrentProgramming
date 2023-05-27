package il.ac.hit.pooly;

public class TaskExecuter implements Runnable{
    private Task task;

    public TaskExecuter(Task task){
        this.task = task; //should use setter? how do we check if a task is valid?
    }

    @Override
    public void run() {
        this.task.perform();
    }
}
