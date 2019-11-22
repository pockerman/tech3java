package datastructs.adt;

import datastructs.adt.utils.BSTInsertStratergy;
import datastructs.adt.utils.TreeNode;
import utils.predicates.IsNull;

import java.util.Comparator;

/**
 * Implementation of a Binary Search Tree
 */
public class BinarySearchTree<E> extends BinaryTree<E> {

    /**
     * Constructor. Create a BST by using Breadth First Search strategy
     */
    BinarySearchTree(Comparator<E> comparator){
        super(new BSTInsertStratergy(comparator));
    }


    /**
     * Push a new element in the ADT
     */
    @Override
    public  void push(E element){

        if(super.root == null){

            this.createRoot(element);
        }
        else {

            boolean rslt = super.getInsertStrategy().insert(super.root, super.root, element, new IsNull<TreeNode<E>>());

            if(rslt) {
                super.nNodes++;
            }
        }
    }
}
