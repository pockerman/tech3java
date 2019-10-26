package utils;

/**
 * An Actor accepts an input and returns an ouput
 */
public interface IActor<InType, OutType> {

    OutType evaluate(InType in);
}
