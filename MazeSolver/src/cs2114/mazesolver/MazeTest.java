package cs2114.mazesolver;

import student.TestCase;

/**
 *  Test class for the Maze class.
 *
 *  @author jhc229
 *  @version 10.11.2014
 */

public class MazeTest extends TestCase
{
    private Maze     maze;
    private Location startLocation;
    private Location goalLocation;
    private Location location;
    private Location invalid;
    private Location invalid2;


    /**
     * setUp method to initialize field.
     */
    public void setUp()
    {
        maze = new Maze(5);
        location = new Location(2, 2);
        startLocation = new Location(0, 0);
        goalLocation = new Location(4, 4);
        invalid = new Location(-1, 0);
        invalid2 = new Location(6, 6);
    }


    /**
     * Test method for getCell method.
     */
    public void testGetCell()
    {

        assertEquals(MazeCell.UNEXPLORED, maze.getCell(location));
        assertEquals(MazeCell.INVALID_CELL, maze.getCell(invalid2));
        assertEquals(MazeCell.INVALID_CELL, maze.getCell(invalid));
    }

    /**
     * Test method for SetCell method
     */
    public void testSetCell()
    {

        maze.setCell(startLocation, MazeCell.WALL);
        assertEquals(MazeCell.WALL, maze.getCell(startLocation));

        maze.setCell(location, MazeCell.UNEXPLORED);
        assertEquals(MazeCell.UNEXPLORED, maze.getCell(location));

        //maze.setCell(invalid2, MazeCell.INVALID_CELL);
        //assertEquals(MazeCell.INVALID_CELL, maze.getCell(invalid2));
    }

    /**
     * Test method for getStartLocation().
     */
    public void testGetStartLocation()
    {
        assertEquals(startLocation, maze.getStartLocation());
    }


    /**
     * Test method for setGoalLocaiton.
     */
    public void testSetGoalLocation()
    {
        {
            maze.setCell(location, MazeCell.WALL);

            maze.setGoalLocation(location);
            Location goal2 = (Location)maze.getGoalLocation();
            assertEquals(2, goal2.x());
            assertEquals(2, goal2.y());

            maze.setGoalLocation(location);
            assertEquals(location, maze.getGoalLocation());

            maze.setCell(goalLocation, MazeCell.WALL);
            maze.setGoalLocation(goalLocation);
            assertEquals(goalLocation, maze.getGoalLocation());
            assertEquals(MazeCell.UNEXPLORED, maze.getCell(goalLocation));
        }
    }

    /**
     * Test method for getGoalLocation.
     */
    public void testGetGoalLocation()
    {
        assertEquals(goalLocation, maze.getGoalLocation());
    }
    /**
     * Test method for size().
     */
    public void testSize()
    {
        assertEquals(5, maze.size());
    }

    /**
     * Test method for setStartLocation method.
     */
    public void testSetStartLocation()
    {
        maze.setCell(location, MazeCell.WALL);
        maze.setStartLocation(location);

        Location start2 = (Location)maze.getStartLocation();
        assertEquals(2, start2.x());
        assertEquals(2, start2.y());
        maze.setStartLocation(location);
        assertEquals(location, maze.getStartLocation());

        maze.setCell(startLocation, MazeCell.WALL);
        maze.setStartLocation(startLocation);
        assertEquals(startLocation, maze.getStartLocation());
        assertEquals(MazeCell.UNEXPLORED, maze.getCell(startLocation));

    }


    /**
     * Test method for solve().
     */
    public void testSolve()
    {
        Location wall1 = new Location(1, 0);
        Location wall2 = new Location(0, 1);
        Location goal = new Location(0, 0);
        Location start = new Location(1, 1);

        maze.setStartLocation(start);
        maze.setGoalLocation(goal);
        maze.setCell(wall1, MazeCell.WALL);
        maze.setCell(wall2, MazeCell.WALL);
        assertNull(maze.solve());

        Maze newMaze = new Maze(5);
        newMaze.setCell(wall1, MazeCell.WALL);
        newMaze.setCell(wall2, MazeCell.WALL);
        assertNull(newMaze.solve());

        Maze newMaze2 = new Maze(5);
        newMaze2.setCell(new Location(3, 4), MazeCell.WALL);
        newMaze2.setCell(new Location(4, 3), MazeCell.WALL);
        assertNull(newMaze2.solve());

        Maze newMaze3 = new Maze(5);
        newMaze3.setStartLocation(location);
        newMaze3.setGoalLocation(startLocation);
        newMaze3.setCell(new Location(2, 3), MazeCell.WALL);
        newMaze3.setCell(new Location(2, 4), MazeCell.WALL);
        newMaze3.setCell(new Location(2, 3), MazeCell.WALL);
        newMaze3.setCell(new Location(3, 2), MazeCell.WALL);
        assertEquals("(2, 2)(2, 1)(2, 0)(1, 0)(1, 1)(1, 2)(1, 3)(1, 4)(0, 4)"
            + "(0, 3)(0, 2)(0, 1)(0, 0)", newMaze3.solve());

        Location newGoal = new Location(3, 4);
        Maze newMaze4 = new Maze(5);
        newMaze4.setStartLocation(newGoal);
        newMaze4.setCell(newGoal, MazeCell.WALL);
        assertEquals("(3, 4)(3, 3)(3, 2)(3, 1)(3, 0)(4, 0)(4, 1)(4, 2)(4, 3)"
            + "(4, 4)", newMaze4.solve());

        Maze newMaze5 = new Maze(5);
        newMaze5.setStartLocation(new Location(2, 2));
        newMaze5.setGoalLocation(new Location(2, 3));
        assertEquals("(2, 2)(2, 1)(2, 0)(3, 0)(3, 1)(3, 2)(3, 3)(3, 4)(2, 4)"
            + "(2, 3)", newMaze5.solve());

        Maze newMaze6 = new Maze(6);
        newMaze6.setGoalLocation(goalLocation);
        newMaze6.setStartLocation(start);
        newMaze6.setCell(location, MazeCell.WALL);
        newMaze6.setCell(new Location(1, 0), MazeCell.WALL);
        newMaze6.setCell(new Location(1, 2), MazeCell.WALL);
        newMaze6.setCell(new Location(1, 4), MazeCell.WALL);
        newMaze6.setCell(new Location(1, 5), MazeCell.WALL);
        newMaze6.setCell(new Location(2, 2), MazeCell.WALL);
        newMaze6.setCell(new Location(2, 3), MazeCell.WALL);
        newMaze6.setCell(new Location(2, 4), MazeCell.WALL);
        newMaze6.setCell(new Location(2, 5), MazeCell.WALL);
        assertEquals("(1, 1)(2, 1)(2, 0)(3, 0)(3, 1)(3, 2)(3, 3)(3, 4)(3, 5)"
            + "(4, 5)(4, 4)", newMaze6.solve());

    }

}
