package maths;

import datastructs.interfaces.IVector;

/**
 * Compute Euclidean distance for vector-like datastructs
 */
public class EuclideanVectorCalculator<T> implements DistanceCalculator<IVector<T>, Double> {


    /**
     * Returns the distance between the two points
     * @param p1 the first  point
     * @param p2 the second point
     */
    @Override
    public Double calculate(final IVector<T> p1, final IVector<T> p2) {

        if(p1 == null || p2 == null){
            throw new NullPointerException("Either p1 or p2 is null");
        }

        if (p1.size() != p2.size()) {
            throw new IllegalStateException("Invalid sizes for IVector. " + p1.size() + " not equal to " + p2.size());
        }

        double rslt = 0.0;

        for (int i = 0; i < p1.size(); i++) {
            rslt += ((Double) p1.get(i) - (Double) p2.get(i)) * ((Double) p1.get(i) - (Double) p2.get(i));
        }

        return Math.sqrt(rslt);
    }

}
