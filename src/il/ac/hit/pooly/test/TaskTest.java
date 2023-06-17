package il.ac.hit.pooly.test;

import il.ac.hit.pooly.TaskExample;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for TaskExample.
 */
class TaskTest {
    private TaskExample taskInstance; // Instance of the TaskExample class

    /**
     * Method executed before each test case.
     * Creates a new instance of TaskExample with a priority of 5.
     */
    @BeforeEach
    void setUp() {
        System.out.println("Setting up the TaskExample instance");
        this.taskInstance = new TaskExample(5);
    }

    /**
     * Method executed after each test case.
     * Resets the taskInstance to null.
     */
    @AfterEach
    void tearDown() {
        this.taskInstance = null;
        System.out.println("Setting TaskExample instance to null");
    }

    /**
     * Test case for the 'perform()' method of TaskExample.
     * It verifies that the 'perform()' method executes without errors,
     * and after a delay, the priority of the task is set to 10.
     */
    @Test
    void perform() {
        System.out.println("Starting 'perform' method test");
        this.taskInstance.perform();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertEquals(this.taskInstance.getPriority(), 10);
    }

    /**
     * Test case for the setPriority() method of TaskExample.
     * It sets a new priority value and checks if the value was updated correctly.
     */
    @Test
    void setPriority() {
        System.out.println("Starting 'setPriority' method test");
        int expectedPriority = 7;
        this.taskInstance.setPriority(7);
        assertEquals(this.taskInstance.getPriority(), expectedPriority);
    }

    /**
     * Test case for the getPriority() method of TaskExample.
     * It checks if the initial priority value is returned correctly.
     */
    @Test
    void getPriority() {
        System.out.println("Starting 'getPriority' method test");
        assertEquals(this.taskInstance.getPriority(), 5);
    }
}
