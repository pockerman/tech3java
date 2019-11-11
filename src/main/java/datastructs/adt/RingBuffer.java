package datastructs.adt;

import java.lang.reflect.Array;

/**
 * A ring buffer is an array together with read and write operations that wrap around. That is, when the
 * last position of the array is reached, writing continues at the begin of the array, thereby erasing the oldest
 * entries. The read operation starts at the oldest entry in the array.
 */
public class RingBuffer<T> {


    /**
     * Constructor
     */
    public RingBuffer(int capacity){

        if(capacity <=0 ){
            throw new IllegalArgumentException("RingBuffer capacity should be greater than 0");
        }

        this.capacity = capacity;
        this.elements = new Object[capacity];
    }


    public long capacity(){
        return this.capacity;
    }

    /**
     * Returns the number of the number of elements in the buffer
     * @return
     */
    public long size(){
        return this.size;
    }


    /**
     * The items of the buffer
     */
    Object[] elements;

    /**
     * How many elements the buffer can store
     */
    long capacity;

    /**
     * How many entries are currently in the buffer
     */
    long size;
}
