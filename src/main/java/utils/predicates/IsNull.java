package utils.predicates;

public final class IsNull<E> implements IPredicate<E>{

    public boolean satisfies(E data){
        return data == null;
    }
}
