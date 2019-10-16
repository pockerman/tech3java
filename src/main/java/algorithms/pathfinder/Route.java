package algorithms.pathfinder;
import java.util.ArrayList;

/**
 * Represents a collection of points that form a path
 * in a maze
 */

public class Route {

    /**
     * Constructor. Constructs an empty route
     */
    public Route(){
        this.points = new ArrayList<Integer>();
    }


    /**
     * Returns true if the Route has no items
     */
    public final boolean empty(){return this.size() == 0;}

    /**
     * Return the i-th item in the route
     */
    public final Integer getItem(int i){
        return this.points.get(i);
    }


    public final void setPath(final ArrayList<Integer> path){

        for (int i = 0; i < path.size(); i++) {
            this.points.add(path.get(i));
        }
    }

    /**
      * Add an item for this route
     */
    public final void addItem(Integer p){
        this.points.add(p);
    }


    /**
     * Returns how many items are in the route
     */
    public final int size(){
        return this.points.size();
    }

    /**
     * The list of points that form the path that this
     * route represents
     */
    private ArrayList<Integer> points;
}
