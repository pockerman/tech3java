package datastructs.adt;

import base.CommonConstants;
import org.junit.Ignore;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class SingleLinkedListTest {

    /**
     * Test Scenario: Application creates an empty list and tries
     * to access the front element
     * Expected Output: An IllegalStateException should be thrown
     */
    @Test(expected = IllegalStateException.class)
    public final void testAccessFrontEmptyList(){

        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();
        linkedList.front();
    }

    /**
     * Test Scenario: Application creates an empty list and tries
     * to pop the front element
     * Expected Output: An IllegalStateException should be thrown
     */
    @Test(expected = IllegalStateException.class)
    public final void testAccessPopFrontEmptyList(){

        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();
        linkedList.popFront();
    }


    /**
     * Test Scenario: Application creates an empty list it pushes at the front
     * some items and attempts to retrieve the front
     * Expected Output: The front item should be returned
     */
    @Test
    public final void testAccessFrontFilledList(){

        SingleLinkedList<Double> linkedList = new SingleLinkedList<Double>();

        for(int i=0; i<50; ++i){
            linkedList.pushFront(new Double(i));
        }

        assertEquals(linkedList.size(), 50);
        Double front = linkedList.front().data;
        assertEquals(front, 49., CommonConstants.getTol());
    }

    /**
     * Test Scenario: Application creates an empty list it pushes at the front
     * some items and attempts to popFront
     * Expected Output: The front item should be returned and size should be decrement by 1
     */
    @Test
    public final void testPopFrontFilledList(){

        SingleLinkedList<Double> linkedList = new SingleLinkedList<Double>();

        for(int i=0; i<50; ++i){
            linkedList.pushFront(new Double(i));
        }

        assertEquals(linkedList.size(), 50);
        Double front = linkedList.popFront().data;
        assertEquals(front, 49., CommonConstants.getTol());
        assertEquals(linkedList.size(), 49);
    }



    /**
     * Test Scenario: Application creates an empty list and tries
     * to push at the front
     * Expected Output: New element should be added at the front
     */
    @Test
    public final void testPushFrontEmptyList(){

        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();
        linkedList.pushFront(new Integer(10));
        assertEquals(linkedList.size(), 1);
    }

    /**
     * Test Scenario: Application creates an empty list and tries
     * to push at the end
     * Expected Output: New element should be added at the end
     */
    @Test
    public final void testPushBackEmptyList(){

        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();
        linkedList.pushBack(new Integer(10));
        assertEquals(linkedList.size(), 1);
    }

    /**
     * Test Scenario: Application creates an empty list and  and fills it
     * with elements. It then tries to push at the end
     * Expected Output: New element should be added at the end
     */
    @Test
    public final void testPushBackFullList(){

        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();

        for(int i=0; i<10; ++i){
            linkedList.pushFront(new Integer(i));
        }

        linkedList.pushBack(new Integer(11));
        assertEquals(linkedList.size(), 11);
        assertEquals(linkedList.back().data.intValue(), 11);
    }

    /**
     * Test Scenario: Application creates an empty list and  and fills it
     * with elements. It then tries to pop at the end
     * Expected Output: The end element should be removed from the list
     */
    @Test
    public final void testpopBackFullList(){

        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();

        for(int i=0; i<10; ++i){
            linkedList.pushFront(new Integer(i));
        }

        linkedList.pushBack(new Integer(11));
        assertEquals(linkedList.size(), 11);
        assertEquals(linkedList.popBack().data.intValue(), 11);
        assertEquals(linkedList.size(), 10);
    }

    /**
     * Test Scenario: Application creates an empty list and  and fills it
     * with elements. It then tries to pop the front until the list is empty
     * Expected Output: The list should be emptied at the end of the iteration
     */
    @Test
    public final void testpopFrontFullList(){

        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();

        for(int i=0; i<10; ++i){
            linkedList.pushFront(new Integer(i));
        }

        int size = linkedList.size();

        for(int i=0; i<size; ++i){
            linkedList.popFront();
        }

        assertEquals(linkedList.size(), 0);
    }


    /**
     * Test Scenario: Application creates an empty list. It pushes one element at the
     * front and retrieves the Node. Then uses this position to insert new element.
     * We test this by doing two popFronts the second pop should be the secondly added node
     * Expected Output: The list should insert the node at the given position
     */
    @Test
    public final void testInsertAtEmptyList(){

        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();

        linkedList.pushFront(new Integer(10));
        SingleLinkedList<Integer>.Node front = linkedList.front();
        SingleLinkedList<Integer>.Node newNode = linkedList.insertAt(front, new Integer(20));
        assertEquals(linkedList.size(), 2);
        front = linkedList.popFront();
        assertEquals(front.next.data.intValue() , newNode.data.intValue());
        newNode = linkedList.popFront();
        assertEquals(newNode.data.intValue(), 20);

    }


    /**
     * Test Scenario: Application creates an empty list. It then pushes
     * several elements into the list. Then queries the list whether an inserted
     * element exists.
     * Expected Output: The element should be found
     */
    @Test
    public final void testContainsFullList(){

        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();

        for(int i=0; i<10; ++i){
            linkedList.pushFront(new Integer(i));
        }

        assertEquals(linkedList.contains(0), true);
    }


    /**
     * Test Scenario: Application creates an empty list. It then pushes
     * several elements into the list. Then queries the list whether an inserted
     * element exists.
     * Expected Output: The element should be found
     */
    @Test
    public final void testFindFullList(){

        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();

        for(int i=0; i<10; ++i){
            linkedList.pushFront(new Integer(i));
        }

        assertEquals(linkedList.find(0).data.intValue(), 0);
    }


    /**
     * Test Scenario: Application creates an empty list and then pushes several elements into it.
     * It then removes an element at a specified position.
     * Expected Output: The element at the given position is removed from the list
     */
    @Test
    @Ignore
    public final void testEraseAtFullList(){

        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();
        for(int i=0; i<10; ++i){
            linkedList.pushFront(new Integer(i));
        }

        linkedList.eraseAt(5);
        assertEquals(linkedList.contains(4), false);
        assertEquals(linkedList.size(), 9);

    }
}
