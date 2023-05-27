package il.ac.hit.pooly;


public class ThreadsPool{

    private TasksList ListOfTasks;
    private PoolOfThreads threadsPool;

    public ThreadsPool(int numOfThreads) throws ThreadsPoolExceptions {
        /*
        Constructor which constructs the class and start a new thread of the PoolOfThreads class. which executes tasks
        */
        this.setThreadsPoolExe(numOfThreads);
        Thread thread = new Thread(this.threadsPool);
        thread.start();
    }

    public void setThreadsPoolExe(int numOfThreads) throws ThreadsPoolExceptions {
        // create list of tasks and initialize instance of PoolOfThreads which manages the threads pool
        this.ListOfTasks = new TasksList();
        this.threadsPool = new PoolOfThreads(numOfThreads, this.ListOfTasks);
    }

    public void submit(Task task) {
        // Add new task the list of tasks
        this.ListOfTasks.addTask(task);
    }
}
