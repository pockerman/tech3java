package datastructs.adt;

import datastructs.interfaces.IBoundedAdt;

import java.util.ArrayList;

/**
 * Implementation of an array based queue data structure
 * The queue is bounded
 */
public class ArrayQueue<E> implements IBoundedAdt<E> {


    /**
     * Creates an empty queue with DEFAULT_CAPACITY
     */
    public ArrayQueue(){
        this(IBoundedAdt.DEFAULT_CAPACITY);
    }


    /**
      * Creates an empty queue with the given capacity
     */
    public ArrayQueue(int capacity){

        create(capacity);
        front_ = -1;
        back_ = -1;
        currentSize_ = 0;
    }


    /**
     * Returns the front index. This is just to accommodate testing
     */
    public final int frontIdx(){return front_;}


    /**
     * Returns the back index. This is just to accommodate testing
     */
    public final int backIdx(){return back_;}


    /**
     * Returns true if the queue is empty
     */
    public final boolean empty(){return (this.currentSize_ == 0);}


    /**
     * Returns true if the queue is full
     */
    public final boolean isFull(){return (this.currentSize_ == this.capacity());}


    /**
     * Returns the capacity of the queue
     */
    public final int capacity(){return this.data_.size();}


    /**
     * Returns how many elements the queue has
     */
    public final int size(){return this.currentSize_;}


    /**
     * Enqueues an element
     */
    public final void push(E element){

        if(this.currentSize_ >= this.capacity()){
            throw new IllegalStateException("Queue is full");
        }

        // check if we should wrap around at the beginning because
        // there is available space there
        if(back_ >= this.capacity()-1 && this.currentSize_ < this.capacity()){
            this.back_ = -1;
        }

        this.back_++;
        this.data_.set(back_, element);
        this.currentSize_++;
    }


    /**
      * Pop off the queue the first element
     */
    public final E pop(){

        if(this.empty()){
            throw new IllegalStateException("The queue is empty");
        }

        this.front_++;
        E rslt = this.data_.get(this.front_);
        this.data_.set(this.front_, null);
        this.currentSize_--;

        if(front_ >= this.capacity()-1){
            this.front_ = -1;
        }

        return rslt;
    }


    /**
     * Create the queue
     */
    private final void create(int capacity){

        if(capacity <= 0){
            throw new IllegalArgumentException("Cannot create a queue with capacity <= 0");
        }

        this.data_ = new ArrayList<E>(capacity);
        for(int i=0; i<capacity; ++i){
            this.data_.add(null);
        }
    }
    private ArrayList<E> data_=null;
    private int front_ = -1;
    private int back_ = -1;
    private int currentSize_ = 0;
}
