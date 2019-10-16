package algorithms.pathfinder;

/**
 *  Some path finding algorithms like A* use heuristic functions
 *  in order to work. Often this heuristic may simply be the distance
 *  between two positions. This interface provides a common contract
 *  for heuristic functions
 */

public interface HeuristicFunction<InputType, OutType> {

    /**
     * Returns an output given the input
     * @param in the input to the heuristic
     * @return OutType the calculated output
     */
    OutType h(final InputType in);
}
