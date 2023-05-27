package il.ac.hit.pooly;

public interface Task extends Comparable<Task> {
    public abstract void perform(); // The object "task"/"flow" to perform
    public abstract void setPriority(int level); // The object priority setter
    public abstract int getPriority(); // The object priority getter

    @Override
    public default int compareTo(Task other) {
        /*
        PriorityBlockingQueue is a sorted Queue by priority (Integer) since it's class we should override
        the method compareTo in order to "force" the PriorityBlockingQueue to sort the queue by different way
        Implement comparison logic based on priority of the object for the PriorityBlockingQueue
        */
        return Integer.compare(other.getPriority(), this.getPriority());
    }
}
