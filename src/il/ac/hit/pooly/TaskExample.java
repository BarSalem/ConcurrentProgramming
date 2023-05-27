package il.ac.hit.pooly;

import java.util.Random;

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
    }

    @Override
    public void setPriority(int level) {
        this.prior=level;
    }

    public int getPriority(){
        return this.prior;
    }

}
