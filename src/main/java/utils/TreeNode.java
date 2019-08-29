package utils;

import java.util.ArrayList;

public class TreeNode<E> {


    public static TreeNode create(TreeNode parent, int level, int nChildren){

        return new TreeNode(null, parent, level, nChildren);
    }


    /**
     * Create a node with the specified data and the given father
     */
    public TreeNode(E data, TreeNode<E> parent, int level, int nChildren){

        this.data_ = data;
        this.parent_ = parent;
        this.level_ = level;

        if(nChildren >=1) {
            this.children_ = new ArrayList<TreeNode<E>>(nChildren);
        }

        for(int c=0; c < nChildren; ++c){
            this.children_.add(null);
        }
    }

    /**
     * Set the data of the node
     */
    public final void setData(E data){this.data_ = data;}


    /**
     * Return the number of children the node has
     */
    public final int getNChildren(){ return this.children_.size(); }


    /**
     * Return the c-th child
     */
    public final TreeNode<E> getChild(int c){

        if(c<0 || c>this.getNChildren()){
            throw new IndexOutOfBoundsException("Invalid child index: "+c+" not in [0"+this.getNChildren()+")");
        }

        return this.children_.get(c);
    }


    /**
     * Set the c-th child
     */
    public final void setChild(int c, TreeNode<E> node){
        this.children_.add(c, node);
    }


    /**
     * Returns the level of the node
     */
    public final int getLevel(){ return this.level_ ; }


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
