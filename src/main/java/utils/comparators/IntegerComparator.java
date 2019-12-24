package utils.comparators;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer t1, Integer t2){

        if(t1 < t2){
            return -1;
        }
        else if(t1 > t2){
            return 1;
        }

        return 0;
    }
}
