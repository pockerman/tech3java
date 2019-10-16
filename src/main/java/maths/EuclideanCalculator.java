package maths;
import geometry.primitives.Point2D;
import utils.Pair;
import algorithms.pathfinder.HeuristicFunction;

/**
 * Euclidean distance calculation
 */

public class EuclideanCalculator<PointType extends Point2D> implements DistanceCalculator<PointType>, HeuristicFunction<Pair<PointType, PointType>, Double> {

    /**
     * Implement the HeuristicFunction interface contract
     * @return the distance between the two points
     */
    public Double h(final Pair<PointType, PointType> in){
        return this.calculate(in.first, in.second);
    }

    /**
     * Returns the distance between the two points
     * @param p1 the first  point
     * @param p2 the second point
     */
    public double calculate(final PointType p1, final PointType p2){

        double dx = p1.getI().doubleValue() - p2.getI().doubleValue();
        double dy = p1.getJ().doubleValue() - p2.getJ().doubleValue();
        return Math.sqrt(dx*dx+dy*dy);
    }
}
