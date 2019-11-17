package datastructs.adt.utils;

import datastructs.adt.utils.TreeNode;

public class TreeNodeCreator<E> {

    public TreeNode<E> create(){
        return new TreeNode<>(null, null, 0, 0);
    }

    public TreeNode<E> create(E data, TreeNode<E> parent, int level, int nChildren){
        return new TreeNode<>(data, parent, level, nChildren);
    }
}
