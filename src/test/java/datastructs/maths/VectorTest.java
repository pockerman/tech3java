package datastructs.maths;
import datastructs.maths.Vector;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;


/**
 * Unit test for the datastructs.maths.Vector class
 */
public class VectorTest {


    /**
     * Test Scenario: The application initializes a Vector with size and val
     * Expected Output: Vector instance should be properly initialized
     */
    @Test
    public void testVectorConstructor(){

        Vector vec = new Vector(10, 0.0);
        assertEquals(vec.size(), 10);
    }

    /**
     * Test Scenario: The application attempts to zero a non initialized Vector
     * Expected Output: Application should throw
     */
    @Test(expected = IllegalStateException.class)
    public void testZeroNonInitializedVector(){
        Vector vec = new Vector();
        vec.zero();
    }


}



