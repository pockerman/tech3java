package algorithms;

import datastructs.adt.TreeNode;
import utils.IPredicate;

/**
 * Implements common tree search methods
 */
public class TreeSearch {


    public <E> TreeNode<E> dfs(TreeNode<E> node, TreeNode<E> parentNode, IPredicate<TreeNode<E>> predicate){

        TreeNode<E> rslt = null;

        if(predicate.satisfies(node)){
            rslt = node;

        }
        else{

            for(int c=0; c<node.nChildren(); ++c){
                dfs(node.getChild(c), node, predicate);
            }
        }

        return rslt;
    }

}
