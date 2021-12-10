package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    private ImmutableLinkedList queue = new ImmutableLinkedList();

    public Object peek() {
        if (!queue.isEmpty()) {
            return queue.getFirst();
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public Object dequeue() {
        if (!queue.isEmpty()) {
            return queue.remove(0);
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void enqueue(Object e) {
        queue.addLast(e);
    }
}
