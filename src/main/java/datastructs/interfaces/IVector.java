package datastructs.interfaces;

import tech.tablesaw.api.Row;

/**
 * General interface for vector-like data structures
 */
public interface IVector<E> extends IAdt<E>, IRowBuilder<IVector<E>> {


    /**
     * Resize the vector
     */
    void resize(int size);


    /**
     * Set the data from the other IVector
     */
    void set(IVector<E> other);


    /**
     * Set the data from Row
     */
    void set(Row row);

    /**
     * Set the i-th entry
     */
    void set(int i, E data);

    /**
     * Add the data to the i-th entry
     */
    void add(int i, E data);

    /**
     * Returns the i-th element
     */
    E get(int i);

    /**
     * Exchange the i-th entry with the j-th
     */
    void excahnge(int i, int k);

}
