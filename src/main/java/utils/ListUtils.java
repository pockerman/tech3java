package utils;
import tech.tablesaw.api.DoubleColumn;

import java.util.List;

/**
 * Utilities for all classes that implement the List interface
 */
public class ListUtils {


    /**
     * Compute the max of the List elements
     */
    public static double max(final List<Double> data){

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
    public static double min(final List<Double> data){

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
    public static double sum(final List<Double> data){

        double rslt = 0.0;

        for(int i=0; i<data.size(); ++i){
                rslt += (double) data.get(i);
        }

        return rslt;
    }


    /**
     * Compute the sum of the absolute values of the List elements
     */
    public static double absSum(final List<Double> data){

        double rslt = 0.0;

        for (int i=0; i<data.size(); ++i){

            rslt += StrictMath.abs((double)data.get(i));
        }

        return rslt;
    }


    /**
     * Normalize the data in the List.
     * See: https://www.statisticshowto.datasciencecentral.com/normalized/
     */
    public static void normalize(List<Double> data){

       double min = ListUtils.min(data);
       double max = ListUtils.max(data);

       for(int i=0; i<data.size(); ++i){
           double x = data.get(i);
           data.set(i, (x-min)/(max - min));
       }
    }

    /**
     * Normalize the data in the List.
     * See: https://www.statisticshowto.datasciencecentral.com/normalized/
     */
    public static void normalize(DoubleColumn data){

        double min = ListUtils.min(data.asList());
        double max = ListUtils.max(data.asList());

        for(int i=0; i<data.size(); ++i){
            double x = data.get(i);
            data.set(i, (x-min)/(max - min));
        }
    }
}
