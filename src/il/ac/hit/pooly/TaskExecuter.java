package il.ac.hit.pooly;

public class TaskExecuter implements Runnable{
    private Task task;

    public TaskExecuter(Task task){
        this.task = task;
    }

    @Override
    public void run() {
        this.task.perform();
    }
}
