package datastructs.interfaces;

import datastructs.interfaces.IAdt;

public interface IBoundedAdt<E> extends IAdt<E> {

    /**
     * The default capacity of the ADT
     */
    static final int DEFAULT_CAPACITY = 10;

    /**
     * Returns the capacity of the ADT
     */
    int capacity();

    /**
     * Returns true if the ADT is full
     */
    boolean isFull();
}
