package environments;

import geometry.Point;
import java.util.ArrayList;

/**
 * Models a 2D Maze
 */
public class Maze2D<CellType extends MazeCell> {


    /**
     * Default constructor
     */
    public Maze2D()
    { }

    /**
     * Construct a xWidth*yWidth maze
     */
    public Maze2D(int xWidth, int yWidth){

        this.initialize(xWidth, yWidth);
    }

    public final void initialize(int xWidth, int yWidth){

        if(xWidth*yWidth == 0){
            throw new IllegalArgumentException("Cannot create a Maze without any cells");
        }

        this.cells = new ArrayList<CellType>(xWidth*yWidth);
        this.xWidth = xWidth;
        this.yWidth = yWidth;
    }

    public final void addCell(CellType cell){

        if(cell == null){
            throw new IllegalArgumentException("Cannot add null cell");
        }
        this.cells.add(cell);
    }


    /**
     * Return the c-th MazeCell
     */
    public final CellType getCell(int c){
        return this.cells.get(c);
    }

    public final void setCellBlockedFlag(int id, String flag){

        this.cells.get(id).setIsBlockedFlag(flag);
    }


    /**
     * Total current size of the maze. That is how many cells the maze currently contains
     * @return
     */
    public final int size(){
        return this.cells.size();
    }


    /**
     * The number of cells in x-direction
     */
    public final int getxWidth(){return this.xWidth;}


    /**
     * The number of cells in y-direction
     */
    public final int getyWidth(){return this.yWidth;}


    /**
     * Returns the cell with the given centroid
     */
    CellType findCell(Point centroid){

        for (int c = 0; c < this.size(); c++) {

            CellType cell = this.cells.get(c);
            if(cell.getCentroid().equals(centroid)){
                return cell;
            }
        }

        return null;
    }


    /**
     * Number of cells in x direction
     */
    private int xWidth;


    /**
     * Number of cells in y direction
     */
    private int yWidth;

    /**
     * The Maze cells
     */
    private ArrayList<CellType> cells;

}
