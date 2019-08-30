package datastructs.adt;

import utils.DfsInsertStrategy;
import org.junit.Test;
import utils.TreeNode;

import static junit.framework.Assert.*;

/**
 * Unit tests for BinaryTree class
 */
public class BinaryTreeTest {

    /**
     * Test Scenario: Application creates an empty tree and adds nodes to the tree
     * Expected Output: New nodes should be successfully added
     */
    @Test
    public void testAddNodes(){

        BinaryTree<Integer> binaryTree = new BinaryTree<>(new DfsInsertStrategy());

        for(int i=0; i<10; ++i){
            binaryTree.push(i);
        }

        assertEquals(binaryTree.size(), 10);
        assertFalse(binaryTree.empty());

        TreeNode<Integer> root = binaryTree.getRoot();
        assertNotNull(root);

        for(int i=0; i<9; ++i){

            root = root.getChild(0);
            assertNotNull(root);
        }
    }
}
