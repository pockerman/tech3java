package datastructs.adt;

import org.junit.Test;
import datastructs.adt.utils.TreeNode;

import java.util.Comparator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BinarySearchTreeTest {

    public static Comparator<Integer> getComparator(){

        Comparator<Integer> comparator = (Integer a, Integer b)->{
            if( a.equals(b)){
                return 0;
            }
            else if( a.intValue() > b.intValue()){
                return 1;
            }

            return -1;
        };

        return comparator;

    }


    /**
     * Test Scenario: Application creates  BST and attempts to insert an item larger than the root
     * Exepected Output: Item should be properly insert at the right subtree of the root
     */
    @Test
    public final void testPushLargerThanRoot(){

        Comparator<Integer> comparator = BinarySearchTreeTest.getComparator();

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

    /**
     * Test Scenario: Application creates  BST and attempts to insert an item smaller than the root
     * Exepected Output: Item should be properly insert at the left subtree of the root
     */
    @Test
    public final void testPushSmallerThanRoot(){

        Comparator<Integer> comparator = BinarySearchTreeTest.getComparator();

        BinarySearchTree<Integer> tree = new BinarySearchTree<>(comparator);

        // insert an item
        tree.push(10);

        TreeNode<Integer> root = tree.getRoot();
        assertEquals("Invalid tree size", tree.size(), 1);
        assertNotNull("Root node is null", root);

        // this should be inserted at the right sub tree
        tree.push(9);

        assertEquals("Invalid tree size", tree.size(), 2);

        TreeNode<Integer> lChild = root.getChild(0);
        assertNotNull("Left child  node is null", lChild);
        assertEquals("Invalid left child data", lChild.getData().intValue(), 9);
    }


    /**
     * Test Scenario: Application creates  BST and attempts to insert an item smaller than the root
     * Exepected Output: Item should be properly insert at the left subtree of the root
     */
    @Test
    public final void testPushSmallerThanRootAndSmallerThanParent(){

        Comparator<Integer> comparator = BinarySearchTreeTest.getComparator();

        BinarySearchTree<Integer> tree = new BinarySearchTree<>(comparator);

        // insert an item
        tree.push(10);

        TreeNode<Integer> root = tree.getRoot();
        assertEquals("Invalid tree size", tree.size(), 1);
        assertNotNull("Root node is null", root);

        // this should be inserted at the right sub tree
        tree.push(9);

        assertEquals("Invalid tree size", tree.size(), 2);

        TreeNode<Integer> lChild = root.getChild(0);
        assertNotNull("Left child  node is null", lChild);
        assertEquals("Invalid left child data", lChild.getData().intValue(), 9);

        tree.push(8);

        assertEquals("Invalid tree size", tree.size(), 3);

        lChild = root.getChild(0).getChild(0);
        assertNotNull("Left child  node is null", lChild);
        assertEquals("Invalid left child data", lChild.getData().intValue(), 8);
    }
}
