package algorithms;

import datastructs.adt.utils.TreeNode;
import utils.predicates.IPredicate;

/**
 * Implements common tree search methods
 */
public class TreeSearch {


    /**
     * Depth First Search starting at node node having parent parentNode that satisfies the given predicate
     */
    public <E> TreeNode<E> dfs(TreeNode<E> node, TreeNode<E> parentNode, IPredicate<TreeNode<E>> predicate){

        TreeNode<E> rslt = null;

        if(predicate.satisfies(node)){
            rslt = node;

            if(node != null){
                parentNode = node.getParent();
            }
        }
        else{

            for(int c = 0; c<node.getNChildren(); ++c){
                dfs(node.getChild(c), node, predicate);
            }
        }

        return rslt;
    }

}
