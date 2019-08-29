package utils;

public class PairCreator {

    public static <T1, T2> Pair<T1, T2> makePair(T1 first, T2 second){
        Pair<T1, T2> pair = new Pair<>();
        pair.first = first;
        pair.second = second;
        return pair;
    }
}
