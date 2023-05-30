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


class ThreadsPoolTest {
    private ThreadsPool threadsPool;

    @BeforeEach
    void setUp() throws ThreadsPoolExceptions {
        System.out.println("Setting up the TaskExample instance");
        this.threadsPool = new ThreadsPool(5);
    }

    @AfterEach
    void tearDown() {
        this.threadsPool = null;
        System.out.println("Setting TaskExample instance to null");
    }

    @Test
    void submit() {
        List<TaskExample> tasksList = new ArrayList<>();
        for (int i=0; i<5; i++){
            TaskExample newTask = new TaskExample(5);
            tasksList.add(newTask);
            this.threadsPool.submit(newTask);
        }
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (TaskExample task: tasksList){
            assertEquals(task.getPriority(), 10);
        }
    }
}