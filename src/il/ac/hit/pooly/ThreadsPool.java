package il.ac.hit.pooly;

/**
 * The ThreadsPool class represents the main ThreadsPool object.
 * It uses a PriorityBlockingQueue to store the tasks based on their priority.
 * It adds the tasks to the listOfTasks.
 */
public class ThreadsPool {

    private TasksList listOfTasks;
    private PoolManager threadsPool;

    /**
     Constructor for the ThreadsPool class.
     Initializes the threads pool by creating an instance of PoolManager and starting it as a new thread.
     */
    public ThreadsPool(int numOfThreads) throws ThreadsPoolExceptions {
        this.setThreadsPoolExe(numOfThreads);
        Thread thread = new Thread(this.threadsPool);
        thread.start();
    }

    /**
     Initializes the list of tasks and the threads pool by creating instances of TasksList and PoolManager respectively.
     */
    private void setThreadsPoolExe(int numOfThreads) throws ThreadsPoolExceptions {
        this.setListOfTasks(new TasksList());
        this.setThreadsPool(new PoolManager(numOfThreads, this.listOfTasks));
    }

    /**
     Getter for the list of tasks.
     */
    public TasksList getListOfTasks() {
        return listOfTasks;
    }

    /**
    Getter for the threads pool.
    */
    public PoolManager getThreadsPool() {
        return threadsPool;
    }

    /**
    Setter for the list of tasks.
    */
    public void setListOfTasks(TasksList listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    /**
    Setter for the threads pool.
    */
    public void setThreadsPool(PoolManager threadsPool) {
        this.threadsPool = threadsPool;
    }

    /**
    Returns a string representation of the ThreadsPool object.
    */
    @Override
    public String toString() {
        return "This class holds a list of tasks object:\n" + listOfTasks + "\nAnd a Threads Pool:\n" + threadsPool;
    }

    /**
    Submits a task to the list of tasks.
    */
    public void submit(Task task) {
        this.listOfTasks.addTask(task);
    }
}
