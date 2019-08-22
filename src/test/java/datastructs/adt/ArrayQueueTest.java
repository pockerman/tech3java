package datastructs.adt;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ArrayQueueTest {

    /**
     * Test Scenario: Application attempts to create a queue with 0 capacity
     * Expected Output: An IllegalArgumentException should be thrown
     */
    @Test(expected = IllegalArgumentException.class)
    public void testZeroCapacityConstruction(){
        ArrayQueue<Double> queue = new ArrayQueue<>(0);
    }

    /**
     * Test Scenario: Application creates an empty queue and tries to access the head element
     * Expected Output: An IllegalStateException should be thrown
     */
    @Test(expected = IllegalStateException.class)
    public final void testEmptyQueuePopOperation(){

        ArrayQueue<Double> queue = new ArrayQueue<Double>();
        queue.pop();
    }

    /**
     * Test Scenario: Application attempts to push into a full queue
     * Expected Output: An IllegalStateException should be throwm
     */
    @Test(expected = IllegalStateException.class)
    public final void testFullQueuePushOperation(){

        ArrayQueue<Double> queue = new ArrayQueue<Double>(10);

        for(int i=0; i<queue.capacity(); ++i){
            queue.push(new Double(i));
        }

        //this should throw
        queue.push(new Double(11));
    }

    /**
     * Test Scenario: Application populates the queue. It then removes an item
     * and then pushes back another item
     * Expected Output: The queue should enqueue the given item at position 0
     */
    @Test
    public final void testFullQueueThenPopThenPush(){

        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
        for(int i=0; i<queue.capacity(); ++i){
            queue.push(i);
        }

        assertEquals(queue.size(), 10);
        assertEquals(queue.backIdx(), 9);
        queue.pop();
        queue.pop();
        assertEquals(queue.frontIdx(), 1);
        queue.push(new Integer(10));
        assertEquals(queue.backIdx(), 0);
    }

    /**
     * Test Scenario: Application populates the queue. It then removes an item
     * and then pushes back another item
     * Expected Output: The queue should enqueue the given item at position 0
     */
    @Test
    public final void testFullQueueThenPopThenPushThenEmpty(){

        ArrayQueue<Integer> queue = new ArrayQueue<>(10);
        for(int i=0; i<queue.capacity(); ++i){
            queue.push(i);
        }

        assertEquals(queue.size(), 10);
        assertEquals(queue.backIdx(), 9);
        queue.pop();
        queue.pop();
        assertEquals(queue.frontIdx(), 1);
        queue.push(new Integer(10));
        assertEquals(queue.backIdx(), 0);

        int i=0;
        while(!queue.empty()){

            var item = queue.pop();
            assertEquals(item.intValue(), i+2);
            i++;
        }

        assertEquals(queue.frontIdx(), 0);
        assertEquals(queue.empty(), true);
        assertEquals(queue.size(), 0);

    }
}
