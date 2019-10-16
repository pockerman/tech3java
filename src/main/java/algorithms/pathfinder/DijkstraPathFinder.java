package algorithms.pathfinder;
import environments.Maze2D;
import environments.MazeCell;
import geometry.primitives.Point2D;
import maths.DistanceCalculator;

import java.util.*;

/**
 * Single source shortest path finding using
 * Dijkstra's algorithm
 * https://www.codingame.com/playgrounds/1608/shortest-paths-with-dijkstras-algorithm/dijkstras-algorithm
 */
public class DijkstraPathFinder<MazeType extends Maze2D> implements PathFinder<MazeType> {


    /**
     * Constructor
     */
    public DijkstraPathFinder(DistanceCalculator distanceCalculator){
        this.distanceCalculator = distanceCalculator;
    }

    /**
     * Given a Maze a start and a goal position
     * constructs a Route
     */
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
        PriorityQueue<DijkstraCell> open = new PriorityQueue<>(new Comparator<DijkstraCell>() {
            @Override
            public int compare(DijkstraPathFinder.DijkstraCell n1, DijkstraPathFinder.DijkstraCell n2) {

                if(n1.distanceToGoal > n2.distanceToGoal)
                    return 1;
                if(n1.distanceToGoal < n2.distanceToGoal)
                    return -1;

                return 0;
            }
        });

        //the explored set of positions
        Set<MazeCell> explored = new HashSet<MazeCell>();

        //this is where we store the path
        HashMap<Integer,Integer> cameFrom = new HashMap<>();

        // populate the priority queue
        //populatePriorityQueue(maze, mCellStart, open);
        // add the source
        open.add(new DijkstraCell(mCellStart, 0));

        while(!open.isEmpty()) {

            //the current node get it out of the open set
            DijkstraCell currentNode = open.poll();

            // we explored this node regardless of the fact if it is the goal or not
            explored.add(currentNode.cell);


            //loop over the neighbors of the current node
            //to expand the search
            for(int n=0; n<currentNode.cell.nNeighbors(); n++){

                MazeCell nn = currentNode.cell.getNeighbor(n);

                if(nn != null && !nn.isBlocked()) {

                    // is the node explored
                    if (!explored.contains(nn)) {

                        // find the DijkstraCell belonging to this
                        DijkstraCell dijkstraCell = new DijkstraCell(nn);

                        int distance = (int) distanceCalculator.calculate(currentNode.cell.getCentroid(), nn.getCentroid());

                        if(currentNode.distanceToGoal != Integer.MAX_VALUE) {

                            if (currentNode.distanceToGoal + distance < dijkstraCell.distanceToGoal) {
                                dijkstraCell.distanceToGoal = currentNode.distanceToGoal + distance;
                                cameFrom.put(dijkstraCell.cell.getId(), currentNode.cell.getId());
                                open.add(dijkstraCell);
                            }
                        }
                        else{

                            // simply add the new Dijkstra cell
                            open.add(dijkstraCell);
                        }
                    }
                }
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



    private class DijkstraCell
    {

        public DijkstraCell(MazeCell cell, int distanceToGoal){
            this.cell = cell;
            this.distanceToGoal = distanceToGoal;
        }

        public DijkstraCell(MazeCell cell){
            this(cell, Integer.MAX_VALUE);
        }

        @Override
        public final boolean equals(Object other){

            if(this == other){
                return true;
            }

            return cell.equals(((DijkstraCell) other).cell);
        }

        @Override
        public final int hashCode(){
            return this.cell.getId();
        }

        MazeCell cell;
        int distanceToGoal = Integer.MAX_VALUE;

    }


    private DistanceCalculator distanceCalculator;
}
