package parallel.partitioners;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RangePartitionerTest {

    /**
     * Test Scenario: The application attempts to partition an evenly divided range
     * Expected Output: Equally sized partitions should be created
     */
    @Test
    public void testEquallySizedPartitions(){

        int start = 0;
        int end = 10;
        List<List<Integer>> partitions = RangePartitioner.partition(start, end, 2);
        assertEquals("Invalid number of partitions", partitions.size(), 2);
        assertEquals("Invalid number of partitions", partitions.get(0).size(), 5);
        assertEquals("Invalid number of partitions", partitions.get(1).size(), 5);
    }

    /**
     * Test Scenario: The application attempts to partition an evenly divided range
     * Expected Output: Equally sized partitions should be created
     */
    @Test
    public void testEquallyNonSizedPartitions(){

        int start = 0;
        int end = 10;
        List<List<Integer>> partitions = RangePartitioner.partition(start, end, 3);
        assertEquals("Invalid number of partitions", 3,partitions.size());

        assertEquals("Invalid number of partitions", 3,partitions.get(0).size());
        assertEquals("Invalid number of partitions", 3, partitions.get(1).size());
        assertEquals("Invalid number of partitions", 4, partitions.get(2).size());
    }


}
