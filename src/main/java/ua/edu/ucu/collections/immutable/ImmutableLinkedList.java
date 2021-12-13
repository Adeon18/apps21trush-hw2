package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableLinkedList implements ImmutableList {

    private final Node head = new Node();
    private final Node tail;
    private int length = 0;

    public ImmutableLinkedList(Object[] elements) {

        Node prev_node = head;

        head.setValue(elements[0]);
        length++;
        for (int i = 1; i < elements.length; i++) {
            // New node initialization
            final Node new_node = new Node();
            new_node.setValue(elements[i]);
            // Node connection
            prev_node.setNext(new_node);
            new_node.setPrevious(prev_node);
            // Now the previous node is different
            prev_node = new_node;
            // Increment the length at each added element
            length++;
        }
        tail = prev_node;
    }

    public ImmutableLinkedList() {
        tail = head;
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(length, new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {

        Object[] newArray = new Object[length + c.length];

        Node prev_node = head;

        for (int i = 0; i < index; i++) {
            newArray[i] = prev_node.getValue();
            prev_node = prev_node.getNext();
        }

        System.arraycopy(c, 0, newArray, index, c.length);

        for (int i = index + c.length; i < length + c.length; i++) {
            newArray[i] = prev_node.getValue();
            prev_node = prev_node.getNext();
        }

        return new ImmutableLinkedList(newArray);
    }

    @Override
    public Object get(int index) {

        if (index >= length) {
            throw new IndexOutOfBoundsException();
        }

        Node prev_node = head;

        for (int i = 0; i < index; i++){
            prev_node = prev_node.getNext();
        }

        return prev_node.getValue();
    }

    @Override
    public ImmutableList remove(int index) {

        if (index >= length) {
            throw new IndexOutOfBoundsException();
        }

        if (length == 1) {
            return new ImmutableLinkedList();
        }

        Object[] newArray = new Object[length - 1];

        Node prev_node = head;

        for (int i = 0; i < length - 1; i++) {
            if (i == index) {
                prev_node = prev_node.getNext();
            }
            newArray[i] = prev_node.getValue();
            prev_node = prev_node.getNext();
        }

        return new ImmutableLinkedList(newArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {

        if (index >= length) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newArray = new Object[length];

        Node prev_node = head;

        for (int i = 0; i < length; i++) {
            if (i == index) {
                newArray[i] = e;
            } else {
                newArray[i] = prev_node.getValue();
            }
            prev_node = prev_node.getNext();
        }

        return new ImmutableLinkedList(newArray);
    }

    @Override
    public int indexOf(Object e) {

        int index = -1;

        Node prev_node = head;

        for (int i = 0; i < length; i++) {
            if (prev_node.getValue().equals(e)) {
                index = i;
                return index;
            }
            prev_node = prev_node.getNext();
        }

        return index;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return (length == 0);
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[length];

        Node prev_node = head;

        for (int i = 0; i < length; i++) {
            newArray[i] = prev_node.getValue();
            prev_node = prev_node.getNext();
        }

        return newArray;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) addAll(0, new Object[]{e});
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) addAll(length, new Object[]{e});
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {

        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        return head.getValue();
    }

    public Object getLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        return (ImmutableLinkedList) remove(length - 1);
    }

    @Override
    public String toString() {

        StringBuilder repr = new StringBuilder("ImmutableLinkedList{");

        Node prev_node = head;
        for (int i = 0; i < length; i++) {
            repr.append(prev_node.getValue()).append(", ");
            prev_node = prev_node.getNext();
        }
        repr.append("}");

        return repr.toString();
    }

    public static void main(String[] args) {
        Object[] j = new Object[]{4, 3, 1, 5};
        Object[] k = new Object[]{4, 5, 6, 7, 8};

        ImmutableLinkedList i1 = new ImmutableLinkedList(j);
        i1 = (ImmutableLinkedList) i1.set(1, 1);

        System.out.println(i1.toString());

//        ImmutableList i2 = i1.get(1, 3);

//        System.out.println(i2.toString());
    }
}
