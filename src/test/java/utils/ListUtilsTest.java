package utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Unit tests for List utilities
 */
public class ListUtilsTest {

    /**
     * Test Scenario: Application wants to zip two unequal lists
     * Expected Ouptu: A zip list should be returned with size equal to the size of
     *                 the list with the smallest size
     */
    @Test
    public void testZip(){

        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            lst1.add(i);
            lst2.add(i);
        }

        for (int i = 0; i < 5; i++) {
            lst2.add(i);
        }

        List<Pair<Integer, Integer>> result = ListUtils.zip(lst1, lst2);
        assertEquals("Invalid list size",result.size(), lst1.size());
    }
}
