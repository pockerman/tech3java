package utils;

/**
 * Insertion strategy for trees
 */
public interface ITreeInsertStrategy<E> {

    /**
     * Insert a new node with the given data in the tree having  the given root which has the given parent
     * The insertion position is meant to satisfy the given predicate. It returns to
     * the calling site the newly created node
     */
    boolean  insert(TreeNode<E> root, TreeNode<E> parent, E data, IPredicate<TreeNode<E>> insertPosPredicate);

    /**
      * Returns the type of the insert
     */
    TreeInsertMethod type();
}
