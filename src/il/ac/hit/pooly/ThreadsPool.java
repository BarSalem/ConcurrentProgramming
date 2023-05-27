package il.ac.hit.pooly;

/**
 *
 */
public class ThreadsPool{

    private TasksList ListOfTasks;//start with a small "L" + change to taskQueue
    private PoolOfThreads threadsPool;

    public ThreadsPool(int numOfThreads) throws ThreadsPoolExceptions {
        this.setThreadsPoolExe(numOfThreads);
        Thread thread = new Thread(this.threadsPool);
        thread.start();
    }

    public void setThreadsPoolExe(int numOfThreads) throws ThreadsPoolExceptions { //should use individual setters for members + should be private
        this.ListOfTasks = new TasksList();
        this.threadsPool = new PoolOfThreads(numOfThreads, this.ListOfTasks);
    }

    public void submit(Task task) { //should validate task?
        this.ListOfTasks.addTask(task);
    }
}
