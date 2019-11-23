package datastructs.adt;

import org.junit.Ignore;
import org.junit.Test;
import static junit.framework.Assert.*;

/**
 * Unit tests for MatrixDataSet
 */
public class MatrixDataSetTest {

    /**
     * Test Scenario: The application attempts to add a new row without specifying the
     *                  the columns
     * Expected Output: IllegalStateException("Columns have not been initialized")
     */
    @Test(expected = IllegalStateException.class)
    @Ignore
    public void testAddRowWithNoColumns(){

       /* MatrixDataSet<Integer> dataSet = new MatrixDataSet<>("TestDataSet");
        RowDataSet<Integer> row = new RowDataSet<>();

        // make sure that indeed there are no columns
        assertEquals("Dataset should have had zero columns but it doesn't", dataSet.nColumns(), 0);

        dataSet.addRow(row);*/

    }


    /**
     * Test Scenario: The application attempts to add a new row with incorrect number of columns
     *
     * Expected Output: IllegalArgumentException(" Row size does not match number of columns")
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testAddRowWithInvalidNumberOfColumns(){

        /*MatrixDataSet<Integer> dataSet = new MatrixDataSet<>("TestDataSet");
        dataSet.addColumns("X", "Y");
        // make sure that indeed there are no columns
        assertEquals("Dataset should have had 2 columns but it doesn't", dataSet.nColumns(), 2);

        RowDataSet<Integer> row = new RowDataSet<>();
        dataSet.addRow(row);*/

    }


    /**
     * Test Scenario: The application attempts to find an existing column
     *
     * Expected Output: The column should be found
     */
    @Test
    @Ignore
    public void testFindExistingColumn(){

        /*MatrixDataSet<Integer> dataSet = new MatrixDataSet<>("TestDataSet");
        dataSet.addColumns("X", "Y", "Z", "W");

        // make sure that indeed there are no columns
        assertEquals("Dataset should have had 4 columns but it doesn't", dataSet.nColumns(), 4);
        assertTrue("Column should exist", dataSet.hasColumn("W"));*/

    }

    /**
     * Test Scenario: The application attempts to find an existing column
     *
     * Expected Output: The column should be found
     */
    @Test
    @Ignore
    public void testFindNonExistingColumn(){

        /*MatrixDataSet<Integer> dataSet = new MatrixDataSet<>("TestDataSet");
        dataSet.addColumns("X", "Y", "Z", "W");

        // make sure that indeed there are no columns
        assertEquals("Dataset should have had 4 columns but it doesn't", dataSet.nColumns(), 4);
        assertFalse("Column should not exist", dataSet.hasColumn("Q"));*/

    }

    /**
     * Test Scenario: The application attempts to access a row with an invalid index
     *
     * Expected Output: IllegalArgumentException("Index "+i+" is out of bounds. Should be in [0,"+this.data.size());
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testInvalidRowIndexAccess(){

        /*MatrixDataSet<Integer> dataSet = new MatrixDataSet<>("TestDataSet");
        dataSet.addColumns("X", "Y", "Z", "W");

        // make sure that indeed there are no columns
        assertEquals("Dataset should have had 4 columns but it doesn't", dataSet.nColumns(), 4);

        RowDataSet<Integer> row = new RowDataSet<>();
        row.add(1, 2, 3, 4);
        dataSet.addRow(row);

        dataSet.getRow(-1);*/

    }

    /**
     * Test Scenario: The application attempts to access a row with an invalid index
     *
     * Expected Output: IllegalArgumentException("Index "+i+" is out of bounds. Should be in [0,"+this.data.size());
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testInvalidRowIndexAccess2(){

        /*MatrixDataSet<Integer> dataSet = new MatrixDataSet<>("TestDataSet");
        dataSet.addColumns("X", "Y", "Z", "W");

        // make sure that indeed there are no columns
        assertEquals("Dataset should have had 4 columns but it doesn't", dataSet.nColumns(), 4);

        RowDataSet<Integer> row = new RowDataSet<>();
        row.add(1, 2, 3, 4);
        dataSet.addRow(row);

        dataSet.getRow(2);*/

    }
}
