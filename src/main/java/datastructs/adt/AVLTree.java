package datastructs.adt;


import datastructs.adt.utils.ITreeBalance;

import java.util.Comparator;

/**
 * Models an AVL Binary Search Tree
 */
public class AVLTree<E> extends BinarySearchTree<E>{

    public AVLTree(Comparator<E> comparator, ITreeBalance balancer){

            super(comparator);
            this.treeBalance = balancer;
    }


    /**
     * Push a new element in the ADT
     */
    @Override
    public  void push(E element){

        // call the base class function to do the insertion
        super.push(element);

        // now re-balance the tree
        treeBalance.balance(this.getRoot());
    }

    private ITreeBalance treeBalance;
}
