package il.ac.hit.pooly;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadsPool{

    private TasksList ListOfTasks;
    private PoolOfThreads threadsPool;

    public ThreadsPool(int numOfThreads){
        this.setThreadsPoolExe(numOfThreads);
        Thread thread = new Thread(this.threadsPool);
        thread.start();
    }

    public void setThreadsPoolExe(int numOfThreads){
        this.ListOfTasks = new TasksList();
        this.threadsPool = new PoolOfThreads(numOfThreads, this.ListOfTasks);
    }

    public void submit(Task task) {
        this.ListOfTasks.addTask(task);
        if (this.ListOfTasks.getListLength() == 1) notify();
    }
}
