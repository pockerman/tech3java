package algorithms.pathfinder;
import environments.Maze2D;
import environments.MazeCell;
import geometry.primitives.Point2D;
import maths.functions.distances.DistanceCalculator;
import utils.Pair;
import utils.PairBuilder;


import java.util.*;

/**
 * A* path finding
 */
public class AstarPathFinder<MazeType extends Maze2D> implements PathFinder<MazeType> {

    /**
     * Constructor
     * @param distanceCalculator
     * @param h
     */
    public AstarPathFinder(DistanceCalculator distanceCalculator,
                           HeuristicFunction<Pair<Point2D<Integer>, Point2D<Integer>>, Double> h){

        this.distanceCalculator = distanceCalculator;
        this.h = h;
    }


    protected class AStarCell
    {
        public MazeCell cell;


        int gCost = Integer.MAX_VALUE;


        int fCost = Integer.MAX_VALUE;


        AStarCell(MazeCell cell){
            this.cell = cell;
        }

        @Override
        public final boolean equals(Object other){

            if(this == other){
                return true;
            }

            if(!(other instanceof AstarPathFinder.AStarCell)){
                return false;
            }

            Point2D<Integer> centroidThis = cell.getCentroid();
            Point2D<Integer> centroidOther = ((AStarCell) other).cell.getCentroid();
            return centroidThis.equals(centroidOther);
        }

        @Override
        public final int hashCode(){
            return cell.getId();
        }

    }

    /**
     * Given a Maze a start and a goal position
     * constructs a Route
     */
    @Override
    public Route find(final MazeType maze, final Point2D<Integer> start, final Point2D<Integer> goal){

        // find the cell that actually corresponds to the source location
        MazeCell mCellStart = maze.findCell(start);

        PathFinder.checkCell(mCellStart);

        // find the cell that actually corresponds to the source location
        MazeCell mCellEnd = maze.findCell(goal);
        PathFinder.checkCell(mCellEnd);

        Route route = new Route();

        // if the given starting point is equal to
        // the goal we have nothing else to do
        if(start.equals(goal)){
            route.addItem(mCellStart.getId());
            return route;
        }

        // cells not explored yet
        PriorityQueue<AStarCell> open = new PriorityQueue<>(new Comparator<AStarCell>() {
            @Override
            public int compare(AStarCell n1, AStarCell n2) {

                if(n1.fCost > n2.fCost)
                    return 1;
                if(n1.fCost < n2.fCost)
                    return -1;

                return 0;
            }
        });

        //the explored set of positions
        Set<MazeCell> explored = new HashSet<MazeCell>();

        //this is where we store the path
        HashMap<Integer,Integer> cameFrom = new HashMap<>();


        AStarCell source = new AStarCell(mCellStart);

        // add the source
        open.add(source);

        //the cost of the path so far leading to this
        //node is obviously zero at the start
        source.gCost = 0;

        //calculate the fCost from start node to the goal
        //at the moment this can be done only heuristically
        source.fCost = this.h.h(PairBuilder.makePair(start, goal)).intValue();

        AStarCell target  = new AStarCell(mCellEnd);


        while(!open.isEmpty()){

            //the current node get it out of the open set
            AStarCell currentNode = open.poll();

            //check if this is the goal
            if(currentNode.equals(target)){
                break;
            }

            //current node is not the goal so proceed
            //add it to the explored (or else called closed) set
            explored.add(currentNode.cell);

            //loop over the neighbors of the current node
            //to expand the search
            for(int n=0; n<currentNode.cell.nNeighbors(); n++){

                //get the n-th neighbor of the current node
                MazeCell nn = currentNode.cell.getNeighbor(n);

                //if the neighbor is null obviously
                //we don't have to continue with this
                //neighbor
                if(nn == null)
                    continue;

                //if we cannot walk in the neighbor neglect it
                if(nn.isBlocked()) {
                    explored.add(nn);
                    continue;
                }

                //check if the neighbor is in the closed set
                //if it is we do nothing
                if(explored.contains(nn))
                    continue;

                AStarCell aCell = new AStarCell(nn);

                //if the neighbor not in open set add it
                if(!open.contains(aCell))
                    open.add(aCell);

                //this actually the cost of the path from the current node
                //to reach its neighbor
                int tgCost = (int)(currentNode.gCost +
                        (int) this.distanceCalculator.calculate(currentNode.cell.getCentroid(), aCell.cell.getCentroid()));

                if (tgCost >= aCell.gCost) {
                    continue; //this is not a better path
                }


                // This path is the best until now. Record it!
                cameFrom.put(aCell.cell.getId(), currentNode.cell.getId());
                aCell.gCost = tgCost;

                //acutally calculate f(nn) = g(nn)+ h(nn)
                aCell.fCost = (int)(aCell.gCost + this.h.h(PairBuilder.makePair(aCell.cell.getCentroid(), goal)));
            }
        }

        ArrayList<Integer> path = this.reconstructPath(cameFrom, mCellEnd);

        route.setPath(path);
        return route;
    }

    /**
     * Reconstructs the path from the given HashMap. Simply works
     * backwards from the target
     */
    private final ArrayList<Integer> reconstructPath(HashMap<Integer,Integer> map, MazeCell goal){

        ArrayList<Integer> nodes = new ArrayList<>();

        if(map.isEmpty()){
            return nodes;
        }

        nodes.add(goal.getId());

        //this the id of the node that led to the goal
        Integer next = map.get(goal.getId());
        nodes.add(next);

        Set<Integer> keys = map.keySet();

        while(keys.contains(next)){

            next = map.get(next);
            nodes.add(next);
        }

        // finally reverse the array
        Collections.reverse(nodes);
        return nodes;
    }

    private HeuristicFunction<Pair<Point2D<Integer>, Point2D<Integer>>, Double> h;
    private DistanceCalculator distanceCalculator;
}
