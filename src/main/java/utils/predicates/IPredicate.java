package utils.predicates;

/**
 *
 * @param <E>
 */
public interface IPredicate<E> {

    boolean satisfies(E data);
}
