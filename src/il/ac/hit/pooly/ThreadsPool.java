package il.ac.hit.pooly;


public class ThreadsPool{

    private TasksList listOfTasks;
    private PoolManager threadsPool;

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
        this.setListOfTasks(new TasksList());
        this.setThreadsPool(new PoolManager(numOfThreads, this.listOfTasks));
    }


    public TasksList getListOfTasks() {
        return listOfTasks;
    }

    public PoolManager getThreadsPool() {
        return threadsPool;
    }

    public void setListOfTasks(TasksList listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    public void setThreadsPool(PoolManager threadsPool) {
        this.threadsPool = threadsPool;
    }

    @Override
    public String toString() {
        return "This class holds list of tasks object:\n" + listOfTasks +"\nAnd Threads Pool:\n" + threadsPool;
    }

    public void submit(Task task) {
        // Add new task the list of tasks
        this.listOfTasks.addTask(task);
    }
}
