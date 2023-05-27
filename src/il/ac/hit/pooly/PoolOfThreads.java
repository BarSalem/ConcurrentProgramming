package il.ac.hit.pooly;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class PoolOfThreads implements Runnable {
    private ThreadPoolExecutor poolOfThreads;

    private TasksList listOfTasks;

    public PoolOfThreads(int numberOfThreads, TasksList listOfTasks) throws ThreadsPoolExceptions {
        // Initialize the class using setter and TaskList object
        this.setPoolOfThreads(numberOfThreads);
        this.setListOfTasks(listOfTasks);
    }

    public ThreadPoolExecutor getPoolOfThreads() {
        return poolOfThreads;
    }

    public TasksList getListOfTasks() {
        return listOfTasks;
    }

    private int getAvailableThreadsNum() {
        // Getting the available threads which can take missions.
        return this.poolOfThreads.getCorePoolSize() - this.poolOfThreads.getActiveCount();
    }

    public void setPoolOfThreads(int numberOfThreads) throws ThreadsPoolExceptions {
        // Verify the numberOfThreads is bigger than 1 and creates new threads pool
        if (numberOfThreads < 1) {
            throw new ThreadsPoolExceptions("Number of threads cannot be lower than 1");
        }
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        this.poolOfThreads = (ThreadPoolExecutor) executor;
    }

    public void setListOfTasks(TasksList listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    @Override
    public String toString() {
        return "This object holds the Threads Pool with: " + poolOfThreads.getCorePoolSize() + " maximum threads";
    }

    @Override
    public void run() {
        /*
        This method runs in thread, it always gets the number of available threads,
        and then execute a task from the PriorityBlockingQueue.
        */
        while (true) {
            this.listOfTasks.printTaskHighestPriority();
            //Check if there are any available threads to receive tasks
            if (this.getAvailableThreadsNum() > 0) {
                Task currTask = this.listOfTasks.getTask();
                System.out.println("Trying to execute task with priority: " + currTask.getPriority());
                //create and execute task using TaskExecuter class
                poolOfThreads.execute(new TaskExecuter(currTask));
                System.out.println("After execute task with priority: " + currTask.getPriority());
                currTask = null; // Garbage collector
            } else {
                // delete before externalize the jar file
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
