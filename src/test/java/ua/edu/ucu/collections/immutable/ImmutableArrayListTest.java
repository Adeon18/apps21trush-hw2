package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest{

    ImmutableArrayList arr1;
    ImmutableArrayList arr2;

    @Before
    public void setUp() {
        arr1 = new ImmutableArrayList(new Object[]{4, 3, 6, 5});
        arr2 = new ImmutableArrayList();
    }
    @Test
    public void testAdd() {
        assertArrayEquals(new Object[]{4, 3, 6, 5, 1}, arr1.add(1).toArray());
    }
    @Test
    public void testTestAdd() {
        assertArrayEquals(new Object[]{4, 3, 1, 6, 5}, arr1.add(2, 1).toArray());
    }
    @Test
    public void testAddAll() {
        assertArrayEquals(new Object[]{4, 3, 6, 5, 1, 2, 3}, arr1.addAll(new Object[]{1, 2, 3}).toArray());
    }
    @Test
    public void testTestAddAll() {
        assertArrayEquals(new Object[]{1, 2, 3, 4, 3, 6, 5}, arr1.addAll(0, new Object[]{1, 2, 3}).toArray());
    }
    @Test
    public void testGet() {
        assertEquals(6, arr1.get(2));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetError() {
        Object result = arr2.get(5);
    }
    @Test
    public void testRemove() {
        assertArrayEquals(new Object[]{4, 3, 5}, arr1.remove(2).toArray());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveError() {
        Object result = arr2.remove(5);
    }
    @Test
    public void testSet() {
        assertArrayEquals(new Object[]{4, 3, 1, 5}, arr1.set(2, 1).toArray());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetError() {
        Object result = arr2.set(5, 10);
    }
    @Test
    public void testIndexOf() {
        assertEquals(2, arr1.indexOf(6));
        assertEquals(-1, arr1.indexOf(10));
    }
    @Test
    public void testSize() {
        assertEquals(4, arr1.size());
        assertEquals(0, arr2.size());
    }
    @Test
    public void testClear() {
        assertArrayEquals(new Object[]{}, arr1.clear().toArray());
        assertArrayEquals(new Object[]{}, arr2.clear().toArray());
    }
    @Test
    public void testIsEmpty() {
        assertTrue(arr2.isEmpty());
        assertFalse(arr1.isEmpty());
    }
    @Test
    public void testToArray() {
        assertArrayEquals(new Object[]{4, 3, 6, 5}, arr1.toArray());
        assertArrayEquals(new Object[]{}, arr2.toArray());
    }
}