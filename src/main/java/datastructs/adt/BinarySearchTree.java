package datastructs.adt;

import datastructs.adt.utils.BSTInsertStratergy;

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

        if(super.root == null){

            this.createRoot(element);
        }
        else {

            boolean rslt = super.getInsertStrategy().insert(super.root, super.root, element, null);

            if(rslt) {
                super.nNodes++;
            }
        }
    }
}
