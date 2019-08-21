package datastructs.adt;

import org.junit.Test;

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
     * Test Scenario: Application populates the queue. It then removes an item
     * and then pushes back another item
     * Expected Output: The queue should enqueue the given item at position 0
     */
}
