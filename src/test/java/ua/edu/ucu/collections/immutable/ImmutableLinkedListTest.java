package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    ImmutableLinkedList ll1;
    ImmutableLinkedList ll2;
    @Before
    public void setUp(){
        ll1 = new ImmutableLinkedList(new Object[]{4, 3, 6, 5});
        ll2 = new ImmutableLinkedList();
    }
    @Test
    public void testAdd() {
        assertArrayEquals(new Object[]{4, 3, 6, 5, 1}, ll1.add(1).toArray());
    }
    @Test
    public void testTestAdd() {
        assertArrayEquals(new Object[]{4, 3, 1, 6, 5}, ll1.add(2, 1).toArray());
    }
    @Test
    public void testAddAll() {
        assertArrayEquals(new Object[]{4, 3, 6, 5, 1, 2, 3}, ll1.addAll(new Object[]{1, 2, 3}).toArray());
    }
    @Test
    public void testTestAddAll() {
        assertArrayEquals(new Object[]{1, 2, 3, 4, 3, 6, 5}, ll1.addAll(0, new Object[]{1, 2, 3}).toArray());
    }
    @Test
    public void testGet() {
        assertEquals(6, ll1.get(2));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetError() {
        Object result = ll2.get(5);
    }
    @Test
    public void testRemove() {
        assertArrayEquals(new Object[]{4, 3, 5}, ll1.remove(2).toArray());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveError() {
        Object result = ll2.remove(5);
    }
    @Test
    public void testSet() {
        assertArrayEquals(new Object[]{4, 3, 1, 5}, ll1.set(2, 1).toArray());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetError() {
        Object result = ll2.set(5, 10);
    }
    @Test
    public void testIndexOf() {
        assertEquals(2, ll1.indexOf(6));
        assertEquals(-1, ll1.indexOf(10));
    }
    @Test
    public void testSize() {
        assertEquals(4, ll1.size());
        assertEquals(0, ll2.size());
    }
    @Test
    public void testClear() {
        assertArrayEquals(new Object[]{}, ll1.clear().toArray());
        assertArrayEquals(new Object[]{}, ll2.clear().toArray());
    }
    @Test
    public void testIsEmpty() {
        assertTrue(ll2.isEmpty());
        assertFalse(ll1.isEmpty());
    }
    @Test
    public void testToArray() {
        assertArrayEquals(new Object[]{4, 3, 6, 5}, ll1.toArray());
        assertArrayEquals(new Object[]{}, ll2.toArray());
    }
    @Test
    public void testAddFirst() {
        assertArrayEquals(new Object[]{1, 4, 3, 6, 5}, ll1.addFirst(1).toArray());
        assertArrayEquals(new Object[]{1}, ll2.addFirst(1).toArray());
    }
    @Test
    public void testAddLast() {
        assertArrayEquals(new Object[]{4, 3, 6, 5, 1}, ll1.addLast(1).toArray());
        assertArrayEquals(new Object[]{1}, ll2.addLast(1).toArray());
    }
    @Test
    public void testGetHead() {
        assertEquals(4, ll1.getHead().getValue());
        assertEquals(3, ll1.getHead().getNext().getValue());
        assertNull(ll1.getHead().getPrevious());

        assertNull(ll2.getHead().getValue());
    }
    @Test
    public void testGetTail() {
        assertEquals(5, ll1.getTail().getValue());
        assertEquals(6, ll1.getTail().getPrevious().getValue());
        assertNull(ll1.getTail().getNext());

        assertNull(ll2.getTail().getValue());
    }
    @Test
    public void testGetFirst() {
        assertEquals(4, ll1.getFirst());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFirstError() {
        assertEquals(100, ll2.getFirst());
    }
    @Test
    public void testGetLast() {
        assertEquals(5, ll1.getLast());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetLastError() {
        assertEquals(100, ll2.getLast());
    }
    @Test
    public void testRemoveFirst() {
        assertArrayEquals(new Object[]{3, 6, 5}, ll1.removeFirst().toArray());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFirstError() {
        assertArrayEquals(new Object[]{3, 6, 5}, ll2.removeFirst().toArray());
    }
    @Test
    public void testRemoveLast() {
        assertArrayEquals(new Object[]{4, 3, 6}, ll1.removeLast().toArray());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveLastError() {
        assertArrayEquals(new Object[]{3, 6, 5}, ll2.removeLast().toArray());
    }
}