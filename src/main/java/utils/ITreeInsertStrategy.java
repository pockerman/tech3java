package utils;

/**
 * Insertion strategy for trees
 */
public interface ITreeInsertStrategy {

    /**
     * Insert a new node with the given data in the tree having  the given root which has the given parent
     * The insertion position is meant to satisfy the given predicate. It returns to
     * the calling site the newly created node
     */
    <DataTp> boolean  insert(TreeNode<DataTp> root, TreeNode<DataTp> parent, DataTp data, IPredicate<TreeNode<DataTp>> insertPosPredicate);
}
