package environments;

import geometry.Point;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a cell in a Maze
 */
public class MazeCell {

    public MazeCell(){

        this(-1, 0, 0, "O");
    }

    /**
     * Constructor
     * @param id The global cell id
     * @param i  The i coordinate of the cell
     * @param j  The j coordinate of the cell
     * @param b  Flag indicating if the cell is blocked or not
     */
    public MazeCell(int id, int i, int j, String b){

        this.centroid = new Point(i, j);
        this.id = id;
        this.setIsBlockedFlag(b);
        neighbors = new HashMap<>();

    }

    /**
     * Return the global id of the cell
     */
    public final int getId(){return this.id;}

    /**
     * Return the centroid of the cell
     * @return
     */
    public final Point getCentroid(){
        return this.centroid;
    }

    /**
     * Set the flag indicating whether the cell is blocked or not
     * Valid Flag parameters are "O" = open or "B" = blocked
     * @param flag
     */
    public final void setIsBlockedFlag(String flag){

        if(flag == null){
            throw new NullPointerException("Null flag was given");
        }

        if(!flag.equals("O") && !flag.equals("B")){

            // perhaps here is better to have a default value and have a warning
            // instead of the exception
            throw new IllegalArgumentException("Flag should be  either O or B but got: "+flag);
        }

        if( flag.equals( "B")){
            this.isBlocked = true;
        }
        else if(flag.equals("O")){
            this.isBlocked = false;
        }
    }


    /**
     *  Returns true if the cell is blocked
     */
    public final boolean isBlocked(){
        return this.isBlocked;
    }


    /**
     * Set the neighbor for the given Direction
     */
    public void setNeighbor(MazeCell n, Direction dir){

        this.neighbors.put(dir,n);
    }

    /**
     * Returns the i-th neighbor
     */
    public final MazeCell getNeighbor(int i){

        Direction dir = Utils.intToDirection(i);
        return neighbors.get(dir);
    }


    /**
     * Returns the i-th neighbor
     */
    public final MazeCell getNeighbor(Direction dir){
        return neighbors.get(dir);
    }

    /**
     * Returns the number of neighbors this cell has
     */
    public final int nNeighbors(){return this.neighbors.size();}


    /**
     * Hold the i, j coordinates of the cell
     */
    private Point centroid;

    /**
     * The global id of the cell
     */
    private int id = -1;


    /**
     * Flag indicating whether the cell is blocked or not
     */
    private boolean isBlocked = false;


    /**
     *  The neighbors of the cell. The mapping of the
     *  Direction to an int is:
     *  int Direction
     *  0   SOUTH
     *  1   EAST
     *  2   NORTH
     *  3   WEST
     */
    Map<Direction, MazeCell> neighbors;

}
