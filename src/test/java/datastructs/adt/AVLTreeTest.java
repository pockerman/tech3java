package datastructs.adt;

import datastructs.adt.utils.AVLTreeBalancer;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AVLTreeTest {

    static Comparator<Integer> getComparator(){
        return (Integer a, Integer b)->{
            if( a.equals(b)){
                return 0;
            }
            else if( a.intValue() > b.intValue()){
                return 1;
            }

            return -1;
        };
    }

    /**
     * Test Scenario: Application inserts a new node that violates the AVL property
     * Expected Output: AVL property should be restored with single rotatio
     */
    @Test
    public void testSingleRotation(){

        AVLTree<Integer> tree = new AVLTree<Integer>(AVLTreeTest.getComparator(), new AVLTreeBalancer());
        tree.push(3);

        assertNotNull("Root node was not created", tree.getRoot());
        assertEquals("Invalid root node data", tree.getRoot().getData().intValue(), 3);

        //add a second node
        tree.push(2);

        assertNotNull("Child node was not created", tree.getRoot().getChild(0));
        assertEquals("Invalid root node data", tree.getRoot().getChild(0).getData().intValue(), 2);

        //this insertion should cause re-balancing
        //add a second node
        tree.push(1);

        assertNotNull("Root node was not created", tree.getRoot());
        assertEquals("Invalid root node data", tree.getRoot().getData().intValue(), 2);
        assertNotNull("Left Child node was not created", tree.getRoot().getChild(0));
        assertEquals("Invalid left child data", tree.getRoot().getChild(0).getData().intValue(), 1);
        assertNotNull("Right child node was not created", tree.getRoot().getChild(1));
        assertEquals("Invalid right child data", tree.getRoot().getChild(0).getData().intValue(), 3);

    }
}
