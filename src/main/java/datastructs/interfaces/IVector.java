package datastructs.interfaces;

/**
 * General interafce for vector-like data structures
 */
public interface IVector<E> extends IAdt<E> {

    /**
     * Returns the i-th element
     */
    E get(int i);
}
