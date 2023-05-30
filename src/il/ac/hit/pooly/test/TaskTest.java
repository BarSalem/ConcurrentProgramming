package il.ac.hit.pooly.test;

import il.ac.hit.pooly.TaskExample;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    private TaskExample taskInstance;

    @BeforeEach
    void setUp() {
        System.out.println("Setting up the TaskExample instance");
        this.taskInstance = new TaskExample(5);
    }

    @AfterEach
    void tearDown() {
        this.taskInstance = null;
        System.out.println("Setting TaskExample instance to null");
    }

    @Test
    void perform() {
        System.out.println("Starting 'perform' method test");
        this.taskInstance.perform();
        try {
            Thread.sleep(7);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertEquals(this.taskInstance.getPriority(), 10);
    }

    @Test
    void setPriority() {
        System.out.println("Starting 'setPriority' method test");
        int expectedPriority = 7;
        this.taskInstance.setPriority(7);
        assertEquals(this.taskInstance.getPriority(), expectedPriority);
    }

    @Test
    void getPriority() {
        System.out.println("Starting 'getPriority' method test");
        assertEquals(this.taskInstance.getPriority(), 5);
    }
}