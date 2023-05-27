package il.ac.hit.pooly;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class PoolOfThreads implements Runnable { //should change name to something more meaningful like: PoolManager
    private ThreadPoolExecutor poolOfThreads; //same as above

    private TasksList listOfTasks;

    public PoolOfThreads(int numberOfThreads, TasksList listOfTasks) throws ThreadsPoolExceptions {
        this.setPoolOfThreads(numberOfThreads);
        this.listOfTasks = listOfTasks;
    }

    public void setPoolOfThreads(int numberOfThreads) throws ThreadsPoolExceptions { //should be private
        if (numberOfThreads < 1) {
            throw new ThreadsPoolExceptions("Number of threads cannot be lower than 1");
        }
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        this.poolOfThreads = (ThreadPoolExecutor) executor;
    }

    private int getAvailableThreadsNum() {
        return this.poolOfThreads.getCorePoolSize() - this.poolOfThreads.getActiveCount();
    }

    @Override
    public void run() {
        while (true) {
            this.listOfTasks.printTaskHighestPriority(); // don't forget to delete
            //check if there are any available threads to receive tasks
            if (this.getAvailableThreadsNum() > 0) {
                //get task with highest priority
                Task currTask = this.listOfTasks.getTask();
                System.out.println("Trying to execute task with priority: " + currTask.getPriority()); // don't forget to delete
                //creat a task executor
                TaskExecuter ExeTask = new TaskExecuter(currTask); //start ExeTask with small "E"
                //execute task
                poolOfThreads.execute(ExeTask);
            }
            //there are no available threads, wait for free thread
            else { //check to use a condition flag instead of sleep
                System.out.println("No available threads");// don't forget to delete
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
            }
        }
    }
}}
