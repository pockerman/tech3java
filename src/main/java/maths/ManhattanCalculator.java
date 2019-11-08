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
}
