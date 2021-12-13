package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NodeTest {

    Node node;
    Node node1;
    Node node2;

    @Before
    public void setUp() {
        node = new Node();
        node1 = new Node();
        node2 = new Node();
        node.setValue(5);
        node1.setValue(6);
        node2.setValue(4);
        node.setNext(node1);
        node.setPrevious(node2);
    }
    @Test
    public void testGetPrevious() {
        assertEquals(node2, node.getPrevious());
    }
    @Test
    public void testSetPrevious() {
        node.setPrevious(node1);
        assertEquals(node1, node.getPrevious());
    }
    @Test
    public void testGetValue() {
        assertEquals(5, node.getValue());
    }
    @Test
    public void testSetValue() {
        node.setValue(1);
        assertEquals(1, node.getValue());
    }
    @Test
    public void testGetNext() {
        assertEquals(node1, node.getNext());
    }
    @Test
    public void testSetNext() {
        node.setNext(node2);
        assertEquals(node2, node.getNext());
    }
}