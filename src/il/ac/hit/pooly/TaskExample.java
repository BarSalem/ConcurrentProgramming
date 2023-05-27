package il.ac.hit.pooly;

public class TaskExample implements Task{
    private int prior;

    public TaskExample(int priority){
        this.setPriority(priority);
    }

    @Override
    public void perform() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("After execute task with priority: " + this.getPriority());// don't forget to delete
    }

    @Override
    public void setPriority(int level) {
        this.prior=level;
    }

    public int getPriority(){ //should add override notation
        return this.prior;
    }

}
