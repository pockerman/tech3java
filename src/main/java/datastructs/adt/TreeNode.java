package datastructs.adt;

import java.util.ArrayList;

public class TreeNode<E> {


    /**
     * Create a node with the specified data and the given father
     */
    public TreeNode(E data, TreeNode<E> parent, int level, int nChildren){

        this.data_ = data;
        this.parent_ = parent;
        this.level_ = level;
        this.children_ = new ArrayList<TreeNode<E>>(nChildren);

        for(int c=0; c < nChildren; ++c){
            this.children_.add(null);
        }
    }

    public final int nChildren(){
        return this.children_.size();
    }

    public final TreeNode<E> getChild(int c){

        if(c<0 || c>this.nChildren()){
            throw new IndexOutOfBoundsException("Invalid child index: "+c+" not in [0"+this.nChildren()+")");
        }

        return this.children_.get(c);
    }

    public final int getLevel(){
        return this.level_ ;
    }


    /**
     * Returns the parent node
     */
    public final TreeNode<E> getParent(){
        return this.parent_;
    }


    protected E data_ = null;
    protected TreeNode<E> parent_ = null;
    protected ArrayList<TreeNode<E>> children_ = null;
    protected int level_ = 0;
}
