package utils;
import java.util.List;

/**
 * Utilities for all classes that implement the List interface
 */
public class ListUtils {


    /**
     * Compute the max of the List elements
     */
    public static double max(final List data){

        double rslt = (double) data.get(0);

        for(int i=1; i<data.size(); ++i){

            if(rslt < (double) data.get(i)){
                rslt = (double) data.get(i);
            }
        }

        return rslt;

    }


    /**
     * Compute the min of the List elements
     */
    public static double min(final List data){

        double rslt = (double) data.get(0);

        for(int i=1; i<data.size(); ++i){

            if(rslt > (double) data.get(i)){
                rslt = (double) data.get(i);
            }
        }

        return rslt;
    }


    /**
     * Compute the sum of the  List elements
     */
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
