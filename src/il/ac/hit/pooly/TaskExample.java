package il.ac.hit.pooly;

/**
This class represents an example task. It implements the Task interface.
It is used for testing purposes only and will be deleted in the final version.
*/
public class TaskExample implements Task {

    private int prior; // The priority of the task

    /**
    Constructor for the TaskExample class.
    Sets the initial priority of the task.
    */
    public TaskExample(int priority) {
        this.setPriority(priority);
    }

    /**
    Implementation of the 'perform()' method from the Task interface.
    Performs the task by simulating a delay of 5 seconds.
    After the task is performed, the priority is set to 10.
    */
    @Override
    public void perform() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished performing the task");
        this.setPriority(10);
    }
    /**
    Implementation of the setPriority() method from the Task interface.
    Sets the priority of the task.
    */
    @Override
    public void setPriority(int level) {
        this.prior = level;
    }
    /**
    Getter for the priority of the task.
    Returns the current priority.
    */
    public int getPriority() {
        return this.prior;
    }
}
