package il.ac.hit.pooly;

public class TaskExecuter implements Runnable{

    private Task task;

    public TaskExecuter(Task task){
        this.setTask(task);
    }

    public Task getTask() {
        return task;
    }

    private void setTask(Task task){
        this.task = task;
    }

    @Override
    public String toString() {
        return "This class holds 'Task' object to perform with priority: " + task.getPriority();
    }

    @Override
    public void run() {
        //trigger the task 'perform' method in order to execute the task functionality, The functionality run as thread.
        this.task.perform();
    }
}
