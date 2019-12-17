package utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {


    /**
     * Create  pairs of consisting of one element from list1 (Pair.first) and one element from list 2 (Pair.second)
     */
    public static <T, U> List<Pair<T,U>> zip(List<T> lst1, List<U> lst2){

        int minSize = lst1.size() > lst2.size()? lst2.size():lst1.size();

        List<Pair<T, U>> result = new ArrayList<>();

        for (int i = 0; i < minSize; i++) {

            Pair<T,U> pair = PairBuilder.makePair(lst1.get(i), lst2.get(i));
            result.add(pair);

        }

        return result;
    }

    public static  <T> double[] toDoubleArray(final List<T> list){

        double[] array = new double[list.size()];

        for(int i=0; i<list.size(); ++i){
            array[i] = ((Double)list.get(i)).doubleValue();
        }

        return array;
    }
}
