package il.ac.hit.pooly;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        ThreadsPool t = new ThreadsPool(2);
        for(int i=0; i<20; i++){
            int randomInt = random.nextInt(100);
            System.out.println("Adding task with priority: " + randomInt);
            t.submit(new TaskExample(randomInt));
        }
        System.out.println("Finish");
    }
}
