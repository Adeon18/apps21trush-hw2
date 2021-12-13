package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    Queue queue;
    Queue queue1;
    @Before
    public void setUp() {
        queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue1 = new Queue();
    }

    @Test
    public void dequeue() {
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }

    @Test
    public void peek() {
        assertEquals(1, queue.peek());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void peekError(){
        queue1.peek();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void dequeueError(){
        queue1.dequeue();
    }

}
