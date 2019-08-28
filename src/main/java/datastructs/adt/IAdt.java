package datastructs.adt;

/**
 * Interface for Abstract Data Types
 */
public interface IAdt<E> {


    /**
     * Returns true if the ADT is empty
     */
    boolean empty();


    /**
     * Returns how many elements the ADT has
     */
    int size();


    /**
     * Push a new element in the ADT
     */
    void push(E element);

}
