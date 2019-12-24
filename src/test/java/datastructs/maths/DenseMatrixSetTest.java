package datastructs.maths;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for DenseMatrix class
 */
public class DenseMatrixSetTest {

    /**
     * Test Scenario: The application attempts to duplicate a column in the matrix
     * Expected Output: The column should be duplicated
     */
    @Test
    public void testDuplicateColumn(){

        DenseMatrixSet matrix = new DenseMatrixSet(3, 3, 1.0);
        matrix.duplicateColumn(2);

        assertEquals("Invalid column size", matrix.n(), 4);
    }
}
