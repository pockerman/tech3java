package datastructs.adt;


import datastructs.adt.utils.ITreeInsertStrategy;
import datastructs.adt.utils.TreeNode;

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
    public final int size(){return this.nNodes_;}


    /**
     * Return the insertion strategy for the node
     */
    public final ITreeInsertStrategy getInsertStrategy() {
        return insertStrategy_;
    }

    public final void setInsertStrategy(ITreeInsertStrategy insertStrategy) {
        this.insertStrategy_ = insertStrategy;
    }


    /**
     * Returns the root node of the tree
     */
    public TreeNode<E> getRoot() {  return root_; }

    /**
     * Constructor
     */
    protected Tree(ITreeInsertStrategy insertStrategy)
    {
        this.insertStrategy_ = insertStrategy;
    }


    /**
     * The root of the tree
     */
    protected TreeNode<E> root_ = null;


    /**
     * How many nodes the Tree has
     */
    protected int nNodes_ = 0;


    /**
     * Insert strategy for the tree
     */
    protected ITreeInsertStrategy insertStrategy_;
}
