package il.ac.hit.pooly;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class PoolOfThreads implements Runnable {
    private ThreadPoolExecutor poolOfThreads;

    private TasksList listOfTasks;

    public PoolOfThreads(int numberOfThreads, TasksList listOfTasks) throws ThreadsPoolExceptions {
        this.setPoolOfThreads(numberOfThreads);
        this.listOfTasks = listOfTasks;
    }

    public void setPoolOfThreads(int numberOfThreads) throws ThreadsPoolExceptions {
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
            this.listOfTasks.printTaskHighestPriority();
            if (this.getAvailableThreadsNum() > 0) {
                Task currTask = this.listOfTasks.getTask();
                System.out.println("Trying to execute task with priority: " + currTask.getPriority());
                TaskExecuter ExeTask = new TaskExecuter(currTask);
                poolOfThreads.execute(ExeTask);
                System.out.println("After execute task with priority: " + currTask.getPriority());
            } else {
                System.out.println("No available threads");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
