package il.ac.hit.pooly;

/**
 * The ThreadsPoolExceptions class represents custom exceptions that can occur in a threads pool.
 * It extends the Exception class to indicate that it is a checked exception.
 */
public class ThreadsPoolExceptions extends Exception {

    /**
     * Constructs a ThreadsPoolExceptions object with the specified error message.
     *
     * @param message The error message describing the exception.
     */
    public ThreadsPoolExceptions(String message) {
        super(message);
    }

    /**
     * Constructs a ThreadsPoolExceptions object with the specified error message and cause.
     *
     * @param message The error message describing the exception.
     * @param cause   The cause of the exception.
     */
    public ThreadsPoolExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
