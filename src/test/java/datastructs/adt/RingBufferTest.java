package datastructs.adt;

import org.junit.Test;

public class RingBufferTest {

    /**
     * Test Scenario: The application attempts to initialize a RingBuffer with
     *                invalid number of elements
     * Expected Output: IllegalArgumentException should be thrown
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSizeBuffer(){
        RingBuffer<Integer> buffer = new RingBuffer<Integer>(-1);
    }
}
