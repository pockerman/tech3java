package algorithms.pathfinder;
import environments.Maze2D;
import environments.MazeBuilder;
import environments.MazeCell;
import environments.MazeCellBuilder;
import geometry.primitives.Point2D;
import maths.EuclideanPoint2DCalculator;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class AStarPathFinderTest {

    /**
     * Test Scenario: The application attempts to use A* algorithm with
     *                an invalid start position i.e. not in the Maze
     * Expected Output: IllegalArgumentException is thrown
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testInvalidStartLocation() {

        try {

            File directory = new File("./");
            String filePath = directory.getCanonicalPath() + "/src/mazes/maze_3_3.txt";

            Maze2D<MazeCell> maze = MazeBuilder.buildMaze2D(filePath, new MazeCellBuilder<MazeCell>(){
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
            assertEquals(maze.size(), 3 * 3);

            PathFinder<Maze2D<MazeCell>> finder = new AstarPathFinder<Maze2D<MazeCell>>(new EuclideanPoint2DCalculator<Point2D<Integer>>(),
                                                    new EuclideanPoint2DCalculator<Point2D<Integer>>());

            Point2D<Integer> start = new Point2D<Integer>(-1, -1);
            Point2D<Integer> end = new Point2D<Integer>(0, 0);

            finder.find(maze, start, end);

        }
        catch (IOException e) {

            System.out.println(e.toString());
        }
    }


    /**
     * Test Scenario: The application attempts to use A* algorithm with
     *                an invalid goal position i.e. not in the Maze
     * Expected Output: IllegalArgumentException is thrown
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testInvalidGoalLocation() {

        try {

            File directory = new File("./");
            String filePath = directory.getCanonicalPath() + "/src/mazes/maze_3_3.txt";

            Maze2D<MazeCell> maze = MazeBuilder.buildMaze2D(filePath, new MazeCellBuilder<MazeCell>(){
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
            assertEquals(maze.size(), 3 * 3);

            PathFinder<Maze2D<MazeCell>> finder = new AstarPathFinder<Maze2D<MazeCell>>(new EuclideanPoint2DCalculator<Point2D<Integer>>(),
                    new EuclideanPoint2DCalculator<Point2D<Integer>>());

            Point2D<Integer> end = new Point2D<Integer>(-1, -1);
            Point2D<Integer> start = new Point2D<Integer>(0, 0);

            finder.find(maze, start, end);

        }
        catch (IOException e) {

            System.out.println(e.toString());
        }
    }


    /**
     * Test Scenario: The application attempts to use A* algorithm with
     *                a blocked goal position i.e. not in the Maze
     * Expected Output: IllegalArgumentException is thrown
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testBlockedGoalLocation() {

        try {

            File directory = new File("./");
            String filePath = directory.getCanonicalPath() + "/src/mazes/maze_3_3.txt";

            Maze2D<MazeCell> maze = MazeBuilder.buildMaze2D(filePath, new MazeCellBuilder<MazeCell>(){
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
            assertEquals(maze.size(), 3 * 3);

            PathFinder<Maze2D<MazeCell>> finder = new AstarPathFinder<Maze2D<MazeCell>>(new EuclideanPoint2DCalculator<Point2D<Integer>>(),
                    new EuclideanPoint2DCalculator<Point2D<Integer>>());


            Point2D<Integer> start = new Point2D<Integer>(0, 0);
            Point2D<Integer> end = new Point2D<Integer>(2, 1);

            finder.find(maze, start, end);

        }
        catch (IOException e) {

            System.out.println(e.toString());
        }
    }


    /**
     * Test Scenario: The application attempts to use A* algorithm with
     *                a blocked start position i.e. not in the Maze
     * Expected Output: IllegalArgumentException is thrown
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testBlockedStartLocation() {

        try {

            File directory = new File("./");
            String filePath = directory.getCanonicalPath() + "/src/mazes/maze_3_3.txt";

            Maze2D<MazeCell> maze = MazeBuilder.buildMaze2D(filePath, new MazeCellBuilder<MazeCell>(){
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
            assertEquals(maze.size(), 3 * 3);

            PathFinder<Maze2D<MazeCell>> finder = new AstarPathFinder<Maze2D<MazeCell>>(new EuclideanPoint2DCalculator<Point2D<Integer>>(),
                    new EuclideanPoint2DCalculator<Point2D<Integer>>());

            Point2D<Integer> end = new Point2D<Integer>(0, 0);
            Point2D<Integer> start = new Point2D<Integer>(2, 1);

            finder.find(maze, start, end);

        }
        catch (IOException e) {

            System.out.println(e.toString());
        }
    }


    /**
     * Test Scenario: The application attempts to use A* algorithm with valid Maze, start and goal location
     * Expected Output: A valid route should be computed
     */
    @Test
    @Ignore
    public void testAstar() {

        try {

            File directory = new File("./");
            String filePath = directory.getCanonicalPath() + "/src/mazes/maze_3_3_lower_right_blocked.txt";

            Maze2D<MazeCell> maze = MazeBuilder.buildMaze2D(filePath, new MazeCellBuilder<MazeCell>(){
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
            assertEquals(maze.size(), 3 * 3);

            PathFinder<Maze2D<MazeCell>> finder = new AstarPathFinder<Maze2D<MazeCell>>(new EuclideanPoint2DCalculator<Point2D<Integer>>(),
                    new EuclideanPoint2DCalculator<Point2D<Integer>>());

            Point2D<Integer> end = new Point2D<Integer>(2, 2);
            Point2D<Integer> start = new Point2D<Integer>(0, 0);


            Route route = finder.find(maze, start, end);

            assertNotNull(route);
            assertEquals(route.size(), 5);

            int[] cellIds = {0, 3, 6, 7, 8};

            for(int i=0; i<route.size(); ++i){
                Integer item = route.getItem(i);
                assertEquals(item.intValue(), cellIds[i]);
            }

        }
        catch (IOException e) {

            System.out.println(e.toString());
        }
    }


    /**
     * Test Scenario: The application attempts to use A* algorithm with valid Maze, start and goal location
     * Expected Output: A valid route should be computed
     */
    @Test
    @Ignore
    public void testAstarMaze1220() {

        try {

            File directory = new File("./");
            String filePath = directory.getCanonicalPath() + "/src/mazes/maze_12_20.txt";

            Maze2D<MazeCell> maze = MazeBuilder.buildMaze2D(filePath, new MazeCellBuilder<MazeCell>(){
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

            PathFinder<Maze2D<MazeCell>> finder = new AstarPathFinder<Maze2D<MazeCell>>(new EuclideanPoint2DCalculator<Point2D<Integer>>(),
                    new EuclideanPoint2DCalculator<Point2D<Integer>>());

            Point2D<Integer> end = new Point2D<Integer>(11, 19);
            Point2D<Integer> start = new Point2D<Integer>(0, 0);

            Route route = finder.find(maze, start, end);
            assertNotNull(route);
            assertFalse(route.empty());


            int[] cellIds = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
                             12, 32, 52, 53, 54, 55, 56, 57, 58,
                             59, 79,  99, 119, 139, 159, 179, 199, 219, 239};

            assertEquals(route.size(), cellIds.length);

            for(int i=0; i<route.size(); ++i){
                Integer item = route.getItem(i);
                assertEquals(item.intValue(), cellIds[i]);
            }

        }
        catch (IOException e) {

            System.out.println(e.toString());
        }
    }



    /**
     * Test Scenario: The application attempts to use A* algorithm with valid Maze, start and goal location
     *                But there is not open path between the start and goal
     * Expected Output: A valid but empty route should be computed
     */
    @Test
    @Ignore
    public void testBlockedDiagonalAstar() {

        try {

            File directory = new File("./");
            String filePath = directory.getCanonicalPath() + "/src/mazes/maze_3_3_open_diagonal_only.txt";

            Maze2D<MazeCell> maze = MazeBuilder.buildMaze2D(filePath, new MazeCellBuilder<MazeCell>(){
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
            assertEquals(maze.size(), 3 * 3);

            PathFinder<Maze2D<MazeCell>> finder = new AstarPathFinder<Maze2D<MazeCell>>(new EuclideanPoint2DCalculator<Point2D<Integer>>(),
                    new EuclideanPoint2DCalculator<Point2D<Integer>>());

            Point2D<Integer> end = new Point2D<Integer>(2, 2);
            Point2D<Integer> start = new Point2D<Integer>(0, 0);

            Route route = finder.find(maze, start, end);

            assertNotNull(route);
            assertEquals(route.size(), 0);
            assertTrue(route.empty());


        }
        catch (IOException e) {

            System.out.println(e.toString());
        }
    }
}
