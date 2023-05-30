package il.ac.hit.pooly;

public class TaskExample implements Task{ // will be deleted (used for testing purposes only
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
        System.out.println("Finished to perform the task");
        this.setPriority(10);
    }

    @Override
    public void setPriority(int level) {
        this.prior=level;
    }

    public int getPriority(){
        return this.prior;
    }

}
