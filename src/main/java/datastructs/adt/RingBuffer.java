package datastructs.adt;

/**
 * A ring buffer is an array together with read and write operations that wrap around. That is, when the
 * last position of the array is reached, writing continues at the begin of the array, thereby erasing the oldest
 * entries. The read operation starts at the oldest entry in the array.
 */
public class RingBuffer<T> {




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

    T[] elements;

    /**
     * How many elements the buffer can store
     */
    long capacity;

    /**
     * How many entries are currently in the buffer
     */
    long size;
}
