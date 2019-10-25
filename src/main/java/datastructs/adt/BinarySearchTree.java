package datastructs.adt;

import utils.BSTInsertStratergy;
import utils.IPredicate;
import utils.TreeNode;
import utils.TreeNodeCreator;

import java.util.Comparator;

/**
 * Implementation of a Binary Search Tree
 */
public class BinarySearchTree<E> extends BinaryTree<E> {

    /**
     * Constructor
     */
    BinarySearchTree(Comparator<E> comparator){
        super(new BSTInsertStratergy(comparator));
    }


    /**
     * Push a new element in the ADT
     */
    @Override
    public  void push(E element){

        if(super.root_ == null){

            this.createRoot(element);
        }
        else {

            boolean rslt = super.getInsertStrategy().insert(super.root_, super.root_, element, null);

            if(rslt) {
                super.nNodes_++;
            }
        }

    }
}
