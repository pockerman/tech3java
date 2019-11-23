package datastructs.interfaces;

/**
 * General interafce for vector-like data structures
 */
public interface IVector<E> extends IAdt<E> {

    /**
     * Build a new instance of this class
     */
    IVector create(int size);

    /**
     * Resize the vector
     */
    void resize(int size);

    /**
     * Set the i-th entry
     */
    void set(int i, E data);

    /**
     * Returns the i-th element
     */
    E get(int i);

    /**
     * Exchange the i-th entry with the j-th
     */
    void excahnge(int i, int k);
}
