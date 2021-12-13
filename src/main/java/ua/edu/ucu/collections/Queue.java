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
            Object element = queue.getFirst();
            queue = queue.removeFirst();
            return element;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void enqueue(Object e) {
        queue = queue.addLast(e);
    }
}
