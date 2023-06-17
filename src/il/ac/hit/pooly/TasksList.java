package il.ac.hit.pooly;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * The TasksList class represents a list of tasks to execute.
 * It uses a PriorityBlockingQueue to store the tasks based on their priority.
 * It is a thread-safe mechanism which locks the
 * list in case of Popping and Adding new tasks.
 */
public class TasksList {
    private PriorityBlockingQueue<Task> listOfTasks;

    /**
     * Constructs a TasksList object with an empty PriorityBlockingQueue.
     */
    public TasksList() {
        this.setListOfTasks(new PriorityBlockingQueue<>());
    }

    /**
     * Retrieves and removes a task by priority from the list of tasks.
     * In case of empty list the take method blocks the thread.
     *
     * @return The task with the highest priority.
     */
    public Task getTask() {
        try {
            // Returns the task with the highest priority in the list.
            return this.listOfTasks.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Getter for the PriorityBlockingQueue class variable.
     *
     * @return PriorityBlockingQueue object.
     */
    public PriorityBlockingQueue<Task> getListOfTasks() {
        return listOfTasks;
    }

    public void setListOfTasks(PriorityBlockingQueue<Task> listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    /**
     * Prints the priority of the task with the highest priority in the list of tasks.
     */
    public void printTaskHighestPriority() {
        if (this.listOfTasks.size() > 0) {
            System.out.println(this.listOfTasks.element().getPriority());
        }
    }

    @Override
    public String toString() {
        return "List of tasks:\n" + listOfTasks;
    }

    /**
     * Adds a task to the list of tasks.
     *
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        // It locks the PriorityBlockingQueue object so there won't
        // be overriding of data while Adding and Popping tasks
        this.listOfTasks.put(task);
    }
}
