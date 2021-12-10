package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import java.util.EmptyStackException;

public class Stack {

    private ImmutableLinkedList stack = new ImmutableLinkedList();

    public void push(Object e) {
        stack.addLast(e);
    }

    public Object pop() {
        if (!stack.isEmpty()) {
            return stack.remove(stack.size() - 1);
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
