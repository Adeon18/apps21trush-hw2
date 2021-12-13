package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {

    private ImmutableLinkedList stack = new ImmutableLinkedList();

    public void push(Object e) {
        stack = stack.addLast(e);
    }

    public Object pop() {
        if (!stack.isEmpty()) {
            Object element = stack.getLast();
            stack = stack.removeLast();
            return element;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public Object peek() {
        if (!stack.isEmpty()) {
            return stack.getLast();
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
