package environments;

import geometry.Point;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class MazeBuilderTest {

    /**
     * Test Scenario: The application attempts to build a Maze with a null filename
     * Expected Output: NullPointerException is thrown
     */
    @Test(expected = NullPointerException.class)
    public void testNullFileName(){

        MazeBuilder.buildMaze2D(null, null);
    }


    /**
     * Test Scenario: The application attempts to build a Maze with an empty  filename string
     * Expected Output: IllegalArgumentException is thrown
     */
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyFileName(){

        MazeBuilder.buildMaze2D("", null);
    }


    /**
     * Test Scenario: The application attempts to build a Maze with a non supporting format
     * Expected Output: IllegalArgumentException is thrown
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testInvalidFormat(){

        MazeBuilder.buildMaze2D("testMazefile.exe", null);
    }


    /**
     * Test Scenario: The application attempts to build a Maze with a valid upporting format
     * Expected Output: The Maze should be build correctly
     */
    @Test
    public void testValidFormat(){

        try {

            File directory = new File("./");
            String filePath = directory.getCanonicalPath() + "/src/main/resources/mazes/maze_3_3.txt";

            Maze2D<MazeCell> maze = MazeBuilder.buildMaze2D(filePath, new MazeCellBuilder<MazeCell>() {
                @Override
                public MazeCell build() {
                    return new MazeCell();
                }

                @Override
                public MazeCell build(int id, int i, int j, String open) {
                    return new MazeCell(id, i, j, open);
                }
            });

            assertNotNull(maze);
            assertEquals(maze.size(), 3*3);

            // let's verify all the data
            for (int c = 0; c < maze.size(); c++) {

                MazeCell cell = maze.getCell(c);
                assertEquals(cell.getId(), c);

                Point centroid = cell.getCentroid();

                if(c == 0){

                    assertTrue(centroid.equals(new Point(0, 0)));
                    assertFalse(cell.isBlocked());

                    assertNull(cell.getNeighbor(Direction.WEST));
                    assertNull(cell.getNeighbor(Direction.SOUTH));

                    assertNotNull(cell.getNeighbor(Direction.EAST));
                    assertEquals(cell.getNeighbor(Direction.EAST).getId(), 1);

                    assertNotNull(cell.getNeighbor(Direction.NORTH));
                    assertEquals(cell.getNeighbor(Direction.NORTH).getId(), 3);
                }
                if(c == 1){

                    assertTrue(centroid.equals(new Point(0, 1)));
                    assertTrue(cell.isBlocked());

                    assertNull(cell.getNeighbor(Direction.SOUTH));

                    assertNotNull(cell.getNeighbor(Direction.WEST));
                    assertEquals(cell.getNeighbor(Direction.WEST).getId(), 0);

                    assertNotNull(cell.getNeighbor(Direction.EAST));
                    assertEquals(cell.getNeighbor(Direction.EAST).getId(), 2);

                    assertNotNull(cell.getNeighbor(Direction.NORTH));
                    assertEquals(cell.getNeighbor(Direction.NORTH).getId(), 4);
                }
                if(c == 2){

                    assertTrue(centroid.equals(new Point(0, 2)));
                    assertTrue(cell.isBlocked());

                    assertNull(cell.getNeighbor(Direction.SOUTH));

                    assertNotNull(cell.getNeighbor(Direction.WEST));
                    assertEquals(cell.getNeighbor(Direction.WEST).getId(), 1);

                    assertNull(cell.getNeighbor(Direction.EAST));


                    assertNotNull(cell.getNeighbor(Direction.NORTH));
                    assertEquals(cell.getNeighbor(Direction.NORTH).getId(), 5);
                }
                if(c == 3){

                    assertTrue(centroid.equals(new Point(1, 0)));
                    assertFalse(cell.isBlocked());

                    assertNull(cell.getNeighbor(Direction.WEST));

                    assertNotNull(cell.getNeighbor(Direction.SOUTH));
                    assertEquals(cell.getNeighbor(Direction.SOUTH).getId(), 0);

                    assertNotNull(cell.getNeighbor(Direction.EAST));
                    assertEquals(cell.getNeighbor(Direction.EAST).getId(), 4);

                    assertNotNull(cell.getNeighbor(Direction.NORTH));
                    assertEquals(cell.getNeighbor(Direction.NORTH).getId(), 6);
                }
                if(c == 4){

                    assertTrue(centroid.equals(new Point(1, 1)));
                    assertFalse(cell.isBlocked());

                    assertNotNull(cell.getNeighbor(Direction.WEST));
                    assertEquals(cell.getNeighbor(Direction.WEST).getId(), 3);

                    assertNotNull(cell.getNeighbor(Direction.SOUTH));
                    assertEquals(cell.getNeighbor(Direction.SOUTH).getId(), 1);

                    assertNotNull(cell.getNeighbor(Direction.EAST));
                    assertEquals(cell.getNeighbor(Direction.EAST).getId(), 5);

                    assertNotNull(cell.getNeighbor(Direction.NORTH));
                    assertEquals(cell.getNeighbor(Direction.NORTH).getId(), 7);
                }
                if(c == 5){

                    assertTrue(centroid.equals(new Point(1, 2)));
                    assertFalse(cell.isBlocked());

                    assertNotNull(cell.getNeighbor(Direction.WEST));
                    assertEquals(cell.getNeighbor(Direction.WEST).getId(), 4);

                    assertNotNull(cell.getNeighbor(Direction.SOUTH));
                    assertEquals(cell.getNeighbor(Direction.SOUTH).getId(), 2);

                    assertNull(cell.getNeighbor(Direction.EAST));

                    assertNotNull(cell.getNeighbor(Direction.NORTH));
                    assertEquals(cell.getNeighbor(Direction.NORTH).getId(), 8);
                }
                if(c == 6){

                    assertTrue(centroid.equals(new Point(2, 0)));
                    assertFalse(cell.isBlocked());

                    assertNull(cell.getNeighbor(Direction.WEST));


                    assertNotNull(cell.getNeighbor(Direction.SOUTH));
                    assertEquals(cell.getNeighbor(Direction.SOUTH).getId(), 3);

                    assertNotNull(cell.getNeighbor(Direction.EAST));
                    assertEquals(cell.getNeighbor(Direction.EAST).getId(), 7);

                    assertNull(cell.getNeighbor(Direction.NORTH));

                }
                if(c == 7){

                    assertTrue(centroid.equals(new Point(2, 1)));
                    assertTrue(cell.isBlocked());

                    assertNotNull(cell.getNeighbor(Direction.WEST));
                    assertEquals(cell.getNeighbor(Direction.WEST).getId(), 6);


                    assertNotNull(cell.getNeighbor(Direction.SOUTH));
                    assertEquals(cell.getNeighbor(Direction.SOUTH).getId(), 4);

                    assertNotNull(cell.getNeighbor(Direction.EAST));
                    assertEquals(cell.getNeighbor(Direction.EAST).getId(), 8);

                    assertNull(cell.getNeighbor(Direction.NORTH));
                }

                if(c == 8){

                    assertTrue(centroid.equals(new Point(2, 2)));
                    assertFalse(cell.isBlocked());

                    assertNotNull(cell.getNeighbor(Direction.WEST));
                    assertEquals(cell.getNeighbor(Direction.WEST).getId(), 7);


                    assertNotNull(cell.getNeighbor(Direction.SOUTH));
                    assertEquals(cell.getNeighbor(Direction.SOUTH).getId(), 5);

                    assertNull(cell.getNeighbor(Direction.EAST));
                    assertNull(cell.getNeighbor(Direction.NORTH));
                }
            }
        }
        catch(IOException e){

            System.out.println(e.toString());
        }
    }


    /**
     * Test Scenario: The application attempts to build a Maze with a valid  format
     * Expected Output: The Maze should be build correctly
     */
    @Test
    public void testValidFormat1220() throws IOException{

        File directory = new File("./");
        String filePath = directory.getCanonicalPath() + "/src/main/resources/mazes/maze_12_20.txt";

        Maze2D<MazeCell> maze = MazeBuilder.buildMaze2D(filePath, new MazeCellBuilder<MazeCell>() {
            @Override
            public MazeCell build() {
                return new MazeCell();
            }

            @Override
            public MazeCell build(int id, int i, int j, String open) {
                return new MazeCell(id, i, j, open);
            }
        });

        assertNotNull(maze);
        assertEquals(maze.size(), 12 * 20);

        int xWidth = maze.getxWidth();
        int yWidth = maze.getyWidth();

        for(int c=0; c<maze.size(); ++c){

            MazeCell cell = maze.getCell(c);

            int i = cell.getCentroid().getI();
            int j = cell.getCentroid().getJ();

            for(int n=0; n<cell.nNeighbors(); ++n){

                Direction dir = Utils.intToDirection(n);
                MazeCell nn = cell.getNeighbor(dir);

                if(dir == Direction.SOUTH){

                    if(nn == null){
                        assertEquals(i, 0);
                    }
                    else{
                        assertEquals(nn.getId(), cell.getId() - yWidth);
                    }
                }

                if(dir == Direction.NORTH){

                    if(nn == null){
                        assertEquals(i, xWidth - 1);
                    }
                    else{
                        assertEquals(nn.getId(), cell.getId() + yWidth);
                    }
                }

                if(dir == Direction.WEST){

                    if(nn == null){
                        assertEquals(j, 0);
                    }
                    else{
                        assertEquals(nn.getId(), cell.getId() - 1);
                    }
                }

                if(dir == Direction.EAST){

                    if(nn == null){
                        assertEquals(j, yWidth - 1);
                    }
                    else{
                        assertEquals(nn.getId(), cell.getId() +1 );
                    }
                }
            }
        }
    }
}
