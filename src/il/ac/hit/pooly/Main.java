package il.ac.hit.pooly;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        ThreadsPool t = null;
        try {
            t = new ThreadsPool(3);
        } catch (ThreadsPoolExceptions e) {
            throw new RuntimeException(e);
        }
        for(int i=0; i<20; i++){
            Thread.sleep(500);
            int randomInt = random.nextInt(100);
            System.out.println("Adding task with priority: " + randomInt);
            t.submit(new TaskExample(randomInt));
        }
        System.out.println("Finish");
    }
}
