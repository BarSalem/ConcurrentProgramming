package il.ac.hit.pooly;

/**
 * The TaskExecuter class represents a task executor that holds a Task object to trigger a 'perform' method.
 * It implements the Runnable interface to allow execution as a separate thread.
 */
public class TaskExecuter implements Runnable {
    private Task task;

    /**
     * Constructs a TaskExecuter object with the specified Task.
     *
     * @param task The Task object to be executed.
     */
    public TaskExecuter(Task task) {
        this.setTask(task);
    }

    private void setTask(Task task) {
        this.task = task;
    }

    /**
     * Returns a string representation of the TaskExecuter object.
     *
     * @return A string describing the TaskExecuter object and its associated Task's priority.
     */
    @Override
    public String toString() {
        return "This class holds 'Task' object to perform with priority: " + task.getPriority();
    }

    /**
     * Executes the task by triggering its perform method in a separate thread.
     */
    @Override
    public void run() {
        this.task.perform();
    }
}