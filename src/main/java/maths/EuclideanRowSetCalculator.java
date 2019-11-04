package maths;

import datastructs.adt.RowDataSet;

public class EuclideanRowSetCalculator<T> implements DistanceCalculator<RowDataSet<T>, Double> {


    /**
     * Returns the distance between the two points
     * @param p1 the first  point
     * @param p2 the second point
     */
    public Double calculate(final RowDataSet<T> p1, final RowDataSet<T> p2){

        if(p1.size() != p2.size()){
            throw new IllegalStateException("Invalid sizes for RowDataSets. "+p1.size()+" not equal to "+p2.size());
        }

        T obj = p1.get(0);

        if( obj instanceof Double){
            return this.doComputeDouble((RowDataSet<Double>)p1, (RowDataSet<Double>) p2);
        }

        throw new IllegalArgumentException("Could not find useful compute function for type T");
    }


    public Double doComputeDouble(final RowDataSet<Double> p1, final RowDataSet<Double> p2){

        if(p1.size() != p2.size()){
            throw new IllegalStateException("Invalid sizes for RowDataSets. "+p1.size()+" not equal to "+p2.size());
        }

        double rslt = 0.0;

        for (int i = 0; i < p1.size(); i++) {
            rslt += (p1.get(i)-p2.get(i))*(p1.get(i)-p2.get(i));
        }

        return Math.sqrt(rslt);
    }
}
