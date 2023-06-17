package il.ac.hit.pooly.test;

import il.ac.hit.pooly.TaskExample;
import il.ac.hit.pooly.ThreadsPool;
import il.ac.hit.pooly.ThreadsPoolExceptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The ThreadsPoolTest class is a JUnit test class for testing the ThreadsPool class.
 */
class ThreadsPoolTest {
    private ThreadsPool threadsPool;

    /**
     * This method is executed before each test method.
     * It initializes a ThreadsPool instance.
     *
     * @throws ThreadsPoolExceptions if an error occurs during the setup.
     */
    @BeforeEach
    void setUp() throws ThreadsPoolExceptions {
        System.out.println("Setting up the ThreadsPool instance");
        this.threadsPool = new ThreadsPool(5);
    }

    /**
     * This method is executed after each test method.
     * It tears down the ThreadsPool instance.
     */
    @AfterEach
    void tearDown() {
        this.threadsPool = null;
        System.out.println("Setting ThreadsPool instance to null");
    }

    /**
     * This method tests the 'submit()' method of the ThreadsPool class.
     * It submits tasks to the pool, waits for some time,
     * and then asserts that the tasks'
     * priorities have been updated correctly.
     * and passed to the thread based on priority
     * As part of the test we push 5 Tasks to the priority queue,
     * and we verify it runs concurrently by checking all
     * the priority of each task are updated to 10. we wait only 7seconds.
     * If the tasks won't run concurrently, it won't be updated to 10.
     */
    @Test
    void submit() {
        // Create new array which holds the TaskExample Object.
        List<TaskExample> tasksList = new ArrayList<>();
        // Creates 5 tasks and add them to the Pool
        for (int i = 0; i < 5; i++) {
            TaskExample newTask = new TaskExample(5);
            tasksList.add(newTask);
            this.threadsPool.submit(newTask);
        }
        // Waiting all the tasks to end
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Verifies all the tasks completed by asserting their priority value
        for (TaskExample task : tasksList) {
            assertEquals(task.getPriority(), 10);
        }
    }
}
