package exercise;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class IQueueTest {
    private static ArrayList<Integer> data = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));

    /**
     * Rigorous Test.
     */
    @Test
    public void enqueueTest() {
        Queue<Integer> queue1 = new IQueue<Integer>();
        for (Integer i : data) {
            Queue<Integer> queue2 = queue1;
            queue1 = queue1.enQueue(i);
            assertTrue(queue1 != queue2);
            assertTrue(queue1.head() == data.get(0));
        }
    }

    @Test
    public void dequeueTest() {
        Queue<Integer> queue1 = new IQueue<Integer>();
        for (Integer i : data) {
            queue1 = queue1.enQueue(i);
        }
        Queue<Integer> queue2 = queue1;
        for (Integer i : data) {
            queue2 = queue1;
            queue1 = queue1.deQueue();
            assertTrue(queue1 != queue2);
        }
    }

    @Test
    public void isEmptyTest() {
        Queue<Integer> queue = new IQueue<Integer>();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void dequeueEmptyTest() {
        Queue<Integer> queue = new IQueue<Integer>();
        queue = queue.deQueue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void headTest() {
        Queue<Integer> queue1 = new IQueue<Integer>();
        for (Integer i : data) {
            queue1 = queue1.enQueue(i);
        }
        assertTrue(queue1.head() == data.get(0));
    }

}
