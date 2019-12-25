package maths;
import algorithms.pathfinder.HeuristicFunction;
import utils.Pair;

public class ManhattanCalculator<PointType> implements DistanceCalculator<PointType, Double>,
        HeuristicFunction<Pair<PointType, PointType>, Double> {


    /**
     * Implement the HeuristicFunction interface contract
     * @return the distance between the two points
     */
    public Double h(final Pair<PointType, PointType> in){
        return this.calculate(in.first, in.second);
    }

    /**
     * Returns the Manhatan distance between the two points
     * @param p1 the first  point
     * @param p2 the second point
     */
    public Double calculate(final PointType p1, final PointType p2){
        return 0.0;
    }

    /**
     * Initialize the min distance
     */
    @Override
    public Double minValue(){return Double.MIN_VALUE; }

    /**
     * Initialize the maximum distance
     */
    @Override
    public Double maxValue(){ return Double.MAX_VALUE; }

    /**
     * Compare the two results
     */
    @Override
    public Double compareMin(Double r1, Double r2){

        if(r1 < r2)
            return r1;

        return r2;
    }


    /**
     * Returns
     * -1 if r1 < r2
     * 0  if r1 == r2
     * 1 if  r1 > r2
     */
    @Override
    public int compare(Double r1, Double r2){

        if(r1 < r2){
            return -1;
        }
        else if(r1 > r2){
            return 1;
        }

        return 0;
    }
}
