package il.ac.hit.pooly;

public class ThreadsPoolExceptions extends Exception {

    public ThreadsPoolExceptions(String message) {
        super(message);
    }

    public ThreadsPoolExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
