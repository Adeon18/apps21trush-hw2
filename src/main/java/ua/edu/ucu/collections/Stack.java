package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import java.util.EmptyStackException;

public class Stack {

    public ImmutableLinkedList getStack() {
        return stack;
    }

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

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack.getStack().toString());
        stack.push(5);
        System.out.println(stack.getStack().toString());
        stack.pop();
        System.out.println(stack.getStack().toString());
    }

}
