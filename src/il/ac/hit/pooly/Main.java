package il.ac.hit.pooly;

public class Main {
    public static void main(String[] args) {
        ThreadsPool t = new ThreadsPool(3);
        for(int i=0; i<20; i++){
            t.submit(new TaskExample(i));
        }
        System.out.println("Finish");
    }
}
