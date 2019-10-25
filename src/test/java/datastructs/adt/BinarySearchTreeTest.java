package datastructs.adt;

import org.junit.Test;
import utils.TreeNode;

import java.util.Comparator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BinarySearchTreeTest {


    /**
     * Test Scenario: Application creates  BST and attempts to insert an item larger than the root
     * Exepected Output: Item should be properly insert at the right subtree of the root
     */
    @Test
    public final void testPushLargerThanRoot(){

        Comparator<Integer> comparator = (Integer a, Integer b)->{
            if( a.equals(b)){
                return 0;
            }
            else if( a.intValue() > b.intValue()){
                return 1;
            }

            return -1;
        };

        BinarySearchTree<Integer> tree = new BinarySearchTree<>(comparator);

        // insert an item
        tree.push(10);

        TreeNode<Integer> root = tree.getRoot();
        assertEquals("Invalid tree size", tree.size(), 1);
        assertNotNull("Root node is null", root);

        // this should be inserted at the right sub tree
        tree.push(15);

        assertEquals("Invalid tree size", tree.size(), 2);

        TreeNode<Integer> rChild = root.getChild(1);
        assertNotNull("Right child  node is null", rChild);
        assertEquals("Invalid right child data", rChild.getData().intValue(), 15);
    }
}
