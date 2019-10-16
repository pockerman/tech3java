package environments;
import geometry.primitives.Point2D;

import java.io.*;


/**
 * Build a Maze
 */
public class MazeBuilder {

    /**
     * Build a maze from a file. If fileName == "" builds a default Maze object
     * @param fileName the name of the file that contains the Maze connectivity
     * @return Maze
     */
    public static <CellType extends MazeCell> Maze2D<CellType> buildMaze2D(String fileName, MazeCellBuilder<CellType> cellBuilder){

        if(fileName == null){
            throw new NullPointerException("No file name has been specified");
        }

        if(fileName == ""){
            throw new IllegalArgumentException("Empty file name string for maze description");
        }

        File file = new File(fileName);
        BufferedReader reader;

        try {

            // the object that reads the file
            reader = new BufferedReader(new FileReader(fileName)); //new FileReader(file));
            Maze2D<CellType> maze = MazeBuilder.doCheckAndBuildMaze2D(reader, cellBuilder);
            MazeBuilder.buildMazeConnectivity2D(maze);
            reader.close();
            return maze;

        }
        catch(FileNotFoundException e){
        }
        catch(IOException e){

            System.out.println(e.toString());
        }

        return null;
    }

    /**
     * Given the Maze instance builds the connectivity for each
     * cell in the maze. The mapping is
     * SOUTH ---> 0
     * EAST ---> 1
     * NORTH ---> 2
     * WEST ---> 3
     * @param maze The maze instance
     */
    protected static <CellType extends MazeCell> void buildMazeConnectivity2D(Maze2D<CellType> maze){

        if(maze == null){
            throw new NullPointerException("Null maze passed to buildMazeConnectivity");
        }

        int xWidth = maze.getxWidth();
        int yWidth = maze.getyWidth();

        // loop over the cells and set up the neighbors
        for (int c = 0; c < maze.size(); c++) {

            MazeCell cell = maze.getCell(c);
            int id = cell.getId();

            Point2D<Integer> pos = cell.getCentroid();
            int i = pos.getI();
            int j = pos.getJ();

            // first set up the SOUTH and NORTH
            if(i == xWidth -1 ){

                // this top row
                cell.setNeighbor(null, Direction.NORTH);
                cell.setNeighbor(maze.getCell(cell.getId() - yWidth), Direction.SOUTH);
            }
            else if(i == 0){

                // this is the bottom row
                cell.setNeighbor(null, Direction.SOUTH);
                cell.setNeighbor(maze.getCell(cell.getId() + yWidth), Direction.NORTH);
            }
            else{

                // set up the North and South cells
                cell.setNeighbor(maze.getCell(cell.getId() - yWidth), Direction.SOUTH);
                cell.setNeighbor(maze.getCell(cell.getId() + yWidth), Direction.NORTH);
            }

            // Set up the EAST and WEST

            if(j == yWidth-1){

                //this is the right most cell it does not have east neighbor
                cell.setNeighbor(null, Direction.EAST);
                cell.setNeighbor(maze.getCell(cell.getId() -1 ), Direction.WEST);
            }
            else if(j == 0){

                // this is the left most row
                cell.setNeighbor(null, Direction.WEST);
                cell.setNeighbor(maze.getCell(cell.getId() + 1 ), Direction.EAST);
            }
            else{
                cell.setNeighbor(maze.getCell(cell.getId() + 1 ), Direction.EAST);
                cell.setNeighbor(maze.getCell(cell.getId() -1 ), Direction.WEST);
            }
        }
    }

    protected  static <CellType extends MazeCell> Maze2D<CellType> doCheckAndBuildMaze2D(BufferedReader reader, MazeCellBuilder<CellType> cellBuilder){

        Maze2D<CellType> maze = new Maze2D<CellType>();

        try {

            String line = reader.readLine();
            MazeBuilder.checkNullLine(line);

            String[] lineData = line.split("=");
            MazeBuilder.stripArray(lineData);
            String[] shouldBe = {"n_rows", "NotZeroInteger"};

            MazeBuilder.checkLineData(lineData, shouldBe);

            int nx = Integer.parseInt(lineData[1]);

            line = reader.readLine();
            MazeBuilder.checkNullLine(line);

            lineData = line.split("=");
            MazeBuilder.stripArray(lineData);
            shouldBe[0] = "n_cols";

            MazeBuilder.checkLineData(lineData, shouldBe);

            int ny = Integer.parseInt(lineData[1]);

            maze.initialize(nx, ny);

            int counter = 0;

            // create the maze cells
            for(int i=0; i<nx; i++){
                for (int j = 0; j < ny; j++) {
                    // ... by default all cells are open
                    maze.addCell(cellBuilder.build(counter++, i, j, "O"));
                }
            }

            // now loop over the file and actually read whether the cell is blocked or not
            line = reader.readLine();
            String[] cellData;
            String[] cellDataShouldBe={"Integer", "OorB"};

            while(line != null){

                cellData = line.split(",");
                MazeBuilder.stripArray(cellData);
                MazeBuilder.checkLineData(cellData, cellDataShouldBe);

                maze.setCellBlockedFlag(Integer.parseInt(cellData[0]), cellData[1]);
                line = reader.readLine();
            }

            return maze;
        }
        catch(IOException e){

        }

        return maze;
    }

    protected static void checkNullLine(String line){
        // here the line may be null or not what we expect
        if(line == null){
            throw new NullPointerException("Null line found");
        }
    }

    protected static void checkLineData(String[] lineIs, String[] lineShouldBe){

        if(lineIs == null || lineIs.length == 0){
            throw new NullPointerException("No line data is provided");
        }

        // here the line may be null or not what we expect
        for(int i=0; i < lineIs.length; ++i) {

            if (lineIs[i] == null) {
                throw new NullPointerException("Null line found when expected: " + lineShouldBe[i]);
            }

            if (!lineIs[i].equals(lineShouldBe[i])) {

                if(lineShouldBe[i].equals("NotZeroInteger" ) ){

                    if( !MazeBuilder.isInteger(lineIs[i])) {
                        throw new IllegalArgumentException("Expecting Integer but got "+lineIs[i]);
                    }

                    if(lineIs[i].equals("0")){
                        throw new IllegalArgumentException("Expecting non zero but got it");
                    }
                }
                else if(lineShouldBe[i].equals("Integer") && !MazeBuilder.isInteger(lineIs[i])){

                    throw new IllegalArgumentException("Expecting an integer. but Found: " + lineIs[i]);
                }
                else if(lineShouldBe[i].equals("OorB") && (!lineIs[i].equals("O") && !lineIs[i].equals("B"))){

                    throw new IllegalArgumentException("Expecting an O or B. but Found: " + lineIs[i]);
                }
            }
        }
    }

    protected static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    protected static final void stripArray(String[] array){

        if(array == null){
            throw new NullPointerException("Null array for strip");
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].strip();
        }
    }

}
