package utils;

import java.util.Comparator;

/**
 *
 */
public class BSTInsertStratergy<E> implements ITreeInsertStrategy<E> {


    /**
     * Constructor
     */
    public BSTInsertStratergy(Comparator<E> comparator){
        this.comparator = comparator;
    }

    /**
     * Insert a new node with the given data in the tree having  the given root which has the given parent
     * The insertion position is meant to satisfy the given predicate. It returns to
     * the calling site the newly created node
     */
    public boolean  insert(TreeNode<E> root, TreeNode<E> parent, E data,
                                    IPredicate<TreeNode<E>> insertPosPredicate){

        if(comparator.compare(data, parent.getData()) == 1){

            parent.setChild(1 , new TreeNode<>(data, parent, 2));
            return true;
        }
        else if(comparator.compare(data, parent.getData() ) == -1){
            parent.setChild(0 , new TreeNode<>(data, parent, 2));
            return true;
        }

        return false;
    }

    /**
     * Returns the type of the insert
     */
    public TreeInsertMethod type(){return TreeInsertMethod.BST; }


    /**
     * The object used for comparisons
     */
    Comparator<E> comparator;
}
