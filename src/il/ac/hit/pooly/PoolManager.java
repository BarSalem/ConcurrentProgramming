package il.ac.hit.pooly;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * The PoolManager class represents a manager for a thread pool.
 * It implements the Runnable interface to allow execution as a separate thread.
 * It redirects all the tasks to the Pool Of Threads
 * by priority when a thread is available.
 */
public class PoolManager implements Runnable {
    private ThreadPoolExecutor poolOfThreads;
    private TasksList listOfTasks;

    /**
     * Constructs a PoolManager object with the specified
     * number of threads and TasksList.
     *
     * @param numberOfThreads The number of threads in the thread pool.
     * @param listOfTasks     The TasksList object containing the tasks to be executed.
     * @throws ThreadsPoolExceptions if the number of threads is less than 1.
     */
    public PoolManager(int numberOfThreads, TasksList listOfTasks)
            throws ThreadsPoolExceptions {
        this.setPoolOfThreads(numberOfThreads);
        this.setListOfTasks(listOfTasks);
    }

    public ThreadPoolExecutor getPoolOfThreads() {
        return poolOfThreads;
    }

    public TasksList getListOfTasks() {
        return listOfTasks;
    }

    /**
     * @return Int which indicates about the number of
     * available threads (which are ready to get a Task)
     */
    private int getAvailableThreadsNum() {
        return this.poolOfThreads.getCorePoolSize() -
                this.poolOfThreads.getActiveCount();
    }

    /**
     * Sets the pool of threads with the specified number of threads.
     *
     * @param numberOfThreads The number of threads in the thread pool.
     * @throws ThreadsPoolExceptions if the number of threads is less than 1.
     */
    public void setPoolOfThreads(int numberOfThreads)
            throws ThreadsPoolExceptions {
        if (numberOfThreads < 1) {
            throw new ThreadsPoolExceptions("Number of threads " +
                    "cannot be lower than 1");
        }
        // Creating a Fixed Threads Pool
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        this.poolOfThreads = (ThreadPoolExecutor) executor;
    }

    /**
     * Sets the List of Tasks with a TasksList object
     */
    public void setListOfTasks(TasksList listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    @Override
    public String toString() {
        return "This object holds the Threads Pool with: " +
                poolOfThreads.getCorePoolSize() + " maximum threads";
    }

    /**
     * Executes tasks from the TasksList in a separate thread.
     * This method continuously checks for available
     * threads and executes tasks if available.
     */
    @Override
    public void run() {
        while (true) {
            // Check if there are any available threads in the pool
            if (this.getAvailableThreadsNum() > 0) {
                // Popping the task with the highest priority
                Task currTask = this.listOfTasks.getTask();
                // Creates new TaskExecuter object with the above task, and executes it
                // in a separated thread from the Pool.
                poolOfThreads.execute(new TaskExecuter(currTask));
                // For garbage collector
                currTask = null;
            }
            // Suspends the checking to avoid busy waiting mode.
            else {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
