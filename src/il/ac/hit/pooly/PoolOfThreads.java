package il.ac.hit.pooly;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class PoolOfThreads implements Runnable{
    private ThreadPoolExecutor poolOfThreads;

    private TasksList listOfTasks;

    public PoolOfThreads(int numberOfThreads, TasksList listOfTasks) {
        this.setPoolOfThreads(numberOfThreads);
        this.listOfTasks = listOfTasks;
    }

    public void setPoolOfThreads(int numberOfThreads) {
        if(numberOfThreads<1){

        }
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        this.poolOfThreads = (ThreadPoolExecutor) executor;
    }

    @Override
    public void run() {
        while(true){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            TaskExecuter ExeTask = new TaskExecuter(this.listOfTasks.getTask());
            poolOfThreads.submit(ExeTask);
        }
    }
}
