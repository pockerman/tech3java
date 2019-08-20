package utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static double max(final List data){

        double rslt = (double) data.get(0);

        for(int i=1; i<data.size(); ++i){

            if(rslt < (double) data.get(i)){
                rslt = (double) data.get(i);
            }
        }

        return rslt;

    }

    public static double min(final List data){

        double rslt = (double) data.get(0);

        for(int i=1; i<data.size(); ++i){

            if(rslt > (double) data.get(i)){
                rslt = (double) data.get(i);
            }
        }

        return rslt;
    }

    public static double sum(final List data){

        double rslt = 0.0;

        for(int i=0; i<data.size(); ++i){
                rslt += (double) data.get(i);
        }

        return rslt;
    }

    /**
     * Compute the sum of the absolute values of the List elements
     */
    public static double absSum(final List data){

        double rslt = 0.0;

        for (int i=0; i<data.size(); ++i){

            rslt += StrictMath.abs((double)data.get(i));
        }

        return rslt;

    }
}
