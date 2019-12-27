package datastructs.interfaces;

import datastructs.utils.RowType;
import tech.tablesaw.api.Row;

import java.util.List;

/**
 * General interface for vector-like data structures
 */
public interface IVector<E> extends IAdt<E>  /*IRowBuilder<IVector<E>>*/ {


    /**
     * Build a new instance of this class
     */
    IVector<E> create(int size);


    /**
     * Build a new instance of this class
     */
    IVector<E> create( E... value);

    /**
     * Create a default vector
     */
    IVector<E> create();


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


    /**
     * Get the elements of the vector as an array
     * @return
     */
    E[] toArray();


    /**
     * get the raw data
     */
    List<E> getRawData();


    /**
     * Returns the type of the vector
     */
    RowType.Type getType();

}
