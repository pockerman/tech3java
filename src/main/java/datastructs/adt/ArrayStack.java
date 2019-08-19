package datastructs.adt;

import java.util.ArrayList;

/**
 * Provides a simple array based implementation of a stack
 */
public class ArrayStack<E> {

    public static final int DEFAULT_CAPACITY = 10;

    /**
     * Create an empty stack
     */
    public ArrayStack(){
        this.stack_ = new ArrayList<E>(ArrayStack.DEFAULT_CAPACITY);
        this.head_pos_ = -1;
    }

    /**
     * Create a stack with the given initial capacity.
     * Note that the stack is still empty i.e.
     * this.empty() == true
     */
    public ArrayStack(int capacity){

        this.stack_ = new ArrayList<E>(capacity);
        this.head_pos_ = -1;
    }


    /**
     * Returns true if the stack is empty
     */
    public final boolean empty(){return (this.head_pos_ == -1);}

    /**
     * Push the new element in the stack
     */
    public final void push(E element){

        head_pos_++;
        boolean success = stack_.add(element);

        //adding to the stack was not possible
        if(!success){
            head_pos_--;
        }
    }

    public final E pop(){

        if(this.empty()){
            throw new IllegalStateException("The stack is empty");
        }

        //return and decrement the head position
        return stack_.get(head_pos_--);
    }

    private ArrayList<E> stack_ =null;
    private int head_pos_ = -1;
}
