package datastructs.adt;

import datastructs.interfaces.IBoundedAdt;

import java.util.ArrayList;

/**
 * Provides a simple array based implementation of a stack
 * The stack is bounded
 */
public class ArrayStack<E> implements IBoundedAdt<E> {


    /**
     * Create an empty stack
     */
    public ArrayStack(){
        this(IBoundedAdt.DEFAULT_CAPACITY);
    }

    /**
     * Create a stack with the given initial capacity.
     * Note that the stack is still empty i.e.
     * this.empty() == true
     */
    public ArrayStack(int capacity){

        create(capacity);
        this.head_pos_ = -1;
        this.size_ = 0;
    }


    /**
     * Returns true if the stack is empty
     */
    public final boolean empty(){return (this.size_ == 0);}


    /**
     * Returns true if the stack is full
     */
    public final boolean isFull(){return (this.size() == this.capacity());}


    /**
     * Returns the capacity of the stack i.e. how many elements it can accommodate
     */
    public final int capacity(){return this.stack_.size();}


    /**
     * Returns the size of the stack which is its capacity
     */
    public final int size(){return this.size_;}


    /**
     * Push the new element in the stack
     */
    public final void push(E element){

        if(this.head_pos_ >= this.capacity()){
            throw new IllegalStateException("Stack is full");
        }

        head_pos_++;
        stack_.set(head_pos_, element);
        size_++;
    }


    /**
     * Pop off the stack the top element
     */
    public final E pop(){

        if(this.empty()){
            throw new IllegalStateException("The stack is empty");
        }

        //return and decrement the head position
        E item = this.stack_.get(this.head_pos_);
        this.stack_.set(head_pos_, null);
        head_pos_--;
        size_ --;
        return item;
    }

    /**
     * Create the stack having the specified capacity
     */
    private final void create(int capacity){

        this.stack_ = new ArrayList<E>(capacity);

        for(int i=0; i<capacity; ++i){
            this.stack_.add(null);
        }
    }

    private ArrayList<E> stack_ =null;
    private int head_pos_ = -1;
    private int size_ = 0;
}
