package datastructs.adt;


import datastructs.adt.utils.ITreeInsertStrategy;
import datastructs.adt.utils.TreeNode;
import datastructs.interfaces.IAdt;

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
    public final int size(){return this.nNodes;}


    /**
     * Return the insertion strategy for the node
     */
    public final ITreeInsertStrategy getInsertStrategy() {
        return this.treeInsertStrategy;
    }

    /**
     * The insertion strategy to be used
     */
    public final void setInsertStrategy(ITreeInsertStrategy insertStrategy) {
        this.treeInsertStrategy = insertStrategy;
    }


    /**
     * Returns the root node of the tree
     */
    public TreeNode<E> getRoot() {  return this.root; }

    /**
     * Constructor
     */
    protected Tree(ITreeInsertStrategy insertStrategy)
    {
        this.treeInsertStrategy = insertStrategy;
    }


    /**
     * The root of the tree
     */
    protected TreeNode<E> root = null;


    /**
     * How many nodes the Tree has
     */
    protected int nNodes = 0;


    /**
     * Insert strategy for the tree
     */
    protected ITreeInsertStrategy treeInsertStrategy;
}
