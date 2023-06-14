package il.ac.hit.pooly;

/**
 * The Task interface represents a task that can be performed.
 * It extends the Comparable interface to provide comparison based on task priority.
 */
public interface Task extends Comparable<Task> {

    /**
     * Performs the task's functionality.
     */
    public abstract void perform();

    /**
     * Sets the priority level of the task.
     *
     * @param level The priority level to be set.
     */
    public abstract void setPriority(int level);

    /**
     * Gets the priority level of the task.
     *
     * @return The priority level of the task.
     */
    public abstract int getPriority();

    /**
     * Compares the task with another task based on their priority.
     * This method is used for sorting tasks in a PriorityBlockingQueue.
     *
     * @param other The task to compare to.
     * @return A negative integer, zero, or a positive integer if this task is less than, equal to,
     * or greater than the other task's priority.
     */

    @Override
    public default int compareTo(Task other) {
        return Integer.compare(other.getPriority(), this.getPriority());
    }
}
