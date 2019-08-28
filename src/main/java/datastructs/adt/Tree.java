package datastructs.adt;

import java.util.ArrayList;

/**
 * Base class for trees
 */
public abstract class Tree<E> implements IAdt<E> {


    /**
     * Returns true if the ADT is empty
     */
    @Override
    public final boolean empty(){return (this.size()==0);}


    /**
     * Returns how many elements the ADT has
     */
    @Override
    public final int size(){return this.nNodes_;};

    /**
     * Constructor
     */
    protected Tree()
    { }


    /**
     * The root of the tree
     */
    protected TreeNode<E> root_ = null;


    /**
     * How many nodes the Tree has
     */
    protected int nNodes_ = 0;
}
