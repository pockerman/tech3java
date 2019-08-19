package datastructs.adt;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ArrayStackTest {


    /**
     * Test Scenario: Application creates an empty stack
     * Expected Output: An empty stack should be returned to the application
     */
    @Test
    public final void testEmptyStackCreation(){

        ArrayStack<Double> stack = new ArrayStack<Double>();
        assertEquals(stack.empty(), true);
    }

    /**
     * Test Scenario: Application creates a stack with a given capacity
     * Expected Output: An empty stack with the given capacity should be returned to the application
     */
    @Test
    public final void testEmptyStackCapacityCreation(){

        ArrayStack<Double> stack = new ArrayStack<Double>(10);
        assertEquals(stack.empty(), true);
    }

    /**
     * Test Scenario: Application creates an empty stack and tries to access the head element
     * Expected Output: An IllegalStateException should be thrown
     */
    @Test(expected = IllegalStateException.class)
    public final void testEmptyStackPopOperation(){

        ArrayStack<Double> stack = new ArrayStack<Double>();
        stack.pop();
    }
}
