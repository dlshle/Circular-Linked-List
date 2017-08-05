/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs143;

import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Xuri
 */
public class EndlessListTest {

    EndlessList<Character> list;
    EndlessList<Character> list1;

    @Before
    public void setUp() {
        list = new EndlessList<>();
        list1 = new EndlessList<>();
    }

    /**
     * Test of addPrev method, of class EndlessList.
     */
    @Test
    public void testAddPrev() {
        list.addPrev('a');
        assertSame(list.getNext(), 'a');
        assertSame(list.getPrev(), 'a');

        list.addPrev('z');
        assertSame(list.getNext(), 'a');
        assertSame(list.getPrev(), 'z');
    }

    /**
     * Test of addNext method, of class EndlessList.
     */
    @Test
    public void testAddNext() {
        list.addNext('a');
        assertSame(list.getNext(), 'a');
        assertSame(list.getPrev(), 'a');

        for (int i = 1; i < 26; i++) {
            list.addNext((char) ('a' + i));
        }

        assertSame(list.getValue(), 'z');
    }

    /**
     * Test of remove method, of class EndlessList.
     */
    @Test
    public void testRemove() {
        //remove from an empty list
        assertSame(list.remove(), null);

        //remove from the list with one node
        list.addNext('a');
        assertSame(list.remove(), 'a');
        assertSame(list.remove(), null);

        //remove multiple items
        for (int i = 0; i < 26; i++) {
            list.addNext((char) ('a' + i));
        }

        assertSame(list.getNext(), 'a');

        for (int i = 0; i < 26; i++) {
            assertSame(list.remove(), (char) ('a' + i));
        }
    }

    /**
     * Test of getValue method, of class EndlessList.
     */
    @Test
    public void testGetValue() {
        assertSame(list.getValue(), null);

        for (int i = 0; i < 26; i++) {
            list.addNext((char) ('a' + i));
        }

        assertSame(list.getValue(), 'z');
    }

    /**
     * Test of setValue method, of class EndlessList.
     */
    @Test
    public void testSetValue() {
        assertFalse(list.setValue('a'));

        list.addNext('a');
        assertTrue(list.setValue('b'));
        assertSame(list.getValue(), 'b');
    }

    /**
     * Test of getPrev method, of class EndlessList.
     */
    @Test
    public void testGetPrev() {
        assertSame(list.getPrev(), null);

        list.addNext('a');
        list.addNext('b');

        assertSame(list.getPrev(), 'a');
        list.remove();
        assertSame(list.getPrev(), 'b');
    }

    /**
     * Test of getNext method, of class EndlessList.
     */
    @Test
    public void testGetNext() {
        assertSame(list.getNext(), null);

        list.addNext('a');
        list.addNext('b');

        assertSame(list.getNext(), 'a');
        list.remove();
        assertSame(list.getNext(), 'b');
    }

    /**
     * Test of moveToNext method, of class EndlessList.
     */
    @Test
    public void testMoveToNext() {
        //Empty list test
        assertFalse(list.moveToNext('a'));

        //one element list
        list.addNext('a');
        assertFalse(list.moveToNext('a'));

        //more than one element test
        list.addNext('b');
        list.addNext('c');
        list.getPrev();
        assertTrue(list.moveToNext('a'));
    }

    /**
     * Test of moveToPrev method, of class EndlessList.
     */
    @Test
    public void testMoveToPrev() {
        //Empty list test
        assertFalse(list.moveToPrev('a'));

        //one element list
        list.addNext('a');
        assertFalse(list.moveToPrev('a'));

        //more than one element test
        list.addNext('b');
        list.addNext('c');
        assertTrue(list.moveToPrev('a'));
    }

    /**
     * Test of iterator method, of class EndlessList.
     */
    @Test
    public void testIterator() {
        Iterator it = list.iterator();
        //test hasNext, next, and remove in an empty list
        assertFalse(it.hasNext());
        assertSame(it.next(), null);
        //see if the program crash
        it.remove();

        //test hasNext, next, and remove with one node
        list.addNext('a');

        //reassign the iterator
        it = list.iterator();

        //test next
        while (it.hasNext()) {
            assertSame(it.next(), 'a');
            it.remove();
        }

        //test remove
        while (it.hasNext()) {
            assertSame(it.next(), 'a');
            it.remove();
        }

        assertFalse(it.hasNext());
        assertSame(it.next(), null);

        //test hasNext and Next with a 26 letter list     
        for (int i = 0; i < 26; i++) {
            list.addNext((char) ('a' + i));
        }
        //move to a
        list.getNext();

        it = list.iterator();

        //test next
        int counter = 0;
        while (it.hasNext()) {
            assertSame(it.next(), (char) ('a' + counter++));
        }

        counter = 0;

        //test remove
        while (it.hasNext()) {
            assertSame(it.next(), (char) ('a' + counter++));
            it.remove();
        }

        assertFalse(it.hasNext());
        assertSame(it.next(), null);
    }

}
