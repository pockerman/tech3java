package datastructs.adt;

import algorithms.TreeSearch;
import utils.IPredicate;

public class BinaryTree<E> extends Tree<E> {


    /**
     * Constructor
     */
    public BinaryTree(){
        super();
    }

    /**
     * Push a new element in the ADT
     */
    public final void push(E element){

        if(super.root_ == null){

            super.root_ = new TreeNode<E>(element, null, 0, 2);
            super.nNodes_++;
        }
        else{

            addRecursive(element);
        }
    }

    /**
     * Recursively add the element at the first null entry that is
     * found. TODO We should specify how the search for inserting is done
     */
    protected void addRecursive(E element){

        TreeSearch search = new TreeSearch();
        TreeNode<E> parentNode = null;
        TreeNode<E> node = search.dfs(super.root_, parentNode, new IPredicate<TreeNode<E>>() {
            @Override
            public boolean satisfies(TreeNode<E> data) {
                return (data == null);
            }
        });

        node = new TreeNode<E>(element, parentNode, parentNode.getLevel()+1, 2 );
    }

}
