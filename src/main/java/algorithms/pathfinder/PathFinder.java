package algorithms.pathfinder;
import environments.MazeCell;
import environments.Maze2D;
import geometry.primitives.Point2D;


/**
 * Base class for modelling a path finder
 */
public interface PathFinder<MazeType> {


    static  <Cell extends MazeCell> void checkCell(Cell c){

        if(c == null){
            throw new IllegalArgumentException("Invalid cell. Cell not in Maze object?");
        }

        if(c.isBlocked()){
            throw new IllegalArgumentException("Cell is blocked. Change your location");
        }
    }

    /**
     * Given a Maze a start and a goal position
     * constructs a Route
     */
    Route find(final MazeType maze, final Point2D<Integer> start, final Point2D<Integer> goal);



}
