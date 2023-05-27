package il.ac.hit.pooly;

public interface Task extends Comparable<Task> {
    public abstract void perform();
    public abstract void setPriority(int level);
    public abstract int getPriority();

    @Override
    public default int compareTo(Task other) {
        // Implement comparison logic based on priority
        return Integer.compare(other.getPriority(), this.getPriority());
    }
}
