package cs2114.mazesolver;

import java.util.Stack;

/**
 * This maze class implements IMaze to represent the maze. Using a square
 * 2-dimensional array (same width and height) of MazeCell values and make it
 * support the operations in this interface.
 * 
 * @author jhc229
 * @version 10.08.2014
 */
public class Maze
    implements IMaze
{
    private MazeCell[][]    mazeGrid;
    private int             size;
    private Location        start;
    private Location        goal;
    private Stack<Location> solution;


    /**
     * Maze should never allow the starting cell or the goal cell to become a
     * wall.
     *
     * @param size represents the size of the maze.
     */
    public Maze(int size)
    {

        mazeGrid = new MazeCell[size][size];
        this.size = size;
        solution = new Stack<Location>();
        
        start = new Location(0, 0);
        goal = new Location(size - 1, size - 1);

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                mazeGrid[i][j] = MazeCell.UNEXPLORED;
            }
        }
    }


    /**
     * Gets the type of cell at the specified location in the maze.
     *
     * @param location to check and make sure cell is not out of bounds.
     * @return a value that indicates the type of cell at that location.
     */
    @Override
    public MazeCell getCell(ILocation location)
    {
        if ((location.x() < 0) || (location.x() >= size) 
            || (location.y() < 0) || (location.y() >= size))
        {
            return MazeCell.INVALID_CELL;
        }
        return mazeGrid[location.x()][location.y()];
    }


    /**
     * Gets the location of the goal in the maze.
     *
     * @return the location of the goal in the maze.
     */
    @Override
    public ILocation getGoalLocation()
    {
        return goal;
    }

    /**
     * Gets the starting location of the maze. the starting location in the maze
     *
     * @return start is the starting location in the maze
     */
    @Override
    public ILocation getStartLocation()
    {
        return start;
    }


    /**
     * There is one special condition that this method must check for: if the
     * cell type is MazeCell.WALL and the location is either the starting
     * location or the goal location, then this method must ignore the request
     * and change nothing.
     *
     * @param location
     *            the location where the wall should be placed.
     * @param cell
     *            type that would be inserted.
     */
    @Override
    public void setCell(ILocation location, MazeCell cell)
    {

        if (getCell(location) == MazeCell.INVALID_CELL
            && (!(location.x() == start.x() && location.y() == start.y()
            || !(location.x() == goal.x() && location.y() == goal.y()))
            || cell != MazeCell.WALL))
        {
            mazeGrid[location.x()][location.y()] = cell;
        }
        else
        {
            mazeGrid[location.x()][location.y()] = cell;
        }
    
    }

    /**
     * This method must check to see if there is a wall at the desired new
     * location for the goal. If there is, you must destroy the wall.
     *
     * @param location is the new location of the goal in the maze.
     */
    @Override
    public void setGoalLocation(ILocation location)
    {
        MazeCell setStart = mazeGrid[location.x()][location.y()];
        if (getCell(location) != MazeCell.INVALID_CELL)
        {
            if (setStart.equals(MazeCell.WALL))
            {
                mazeGrid[location.x()][location.y()] = MazeCell.UNEXPLORED;
            }
            goal = (Location)location;
        }
    }


    /**
     * This method must check to see if there is a wall at the desired new
     * location for the starting point. If there is, you must destroy the wall.
     *
     * @param location the new starting location in the maze.
     */
    @Override
    public void setStartLocation(ILocation location)
    {
        MazeCell setStart = mazeGrid[location.x()][location.y()];
        if (setStart != MazeCell.INVALID_CELL)
        {
            if (setStart.equals(MazeCell.WALL))
            {
                mazeGrid[location.x()][location.y()] = MazeCell.UNEXPLORED;
            }
            start = (Location)location;
        }
        else
        {
            mazeGrid[location.x()][location.y()] = MazeCell.INVALID_CELL;
        }

    }

    /**
     * Gets the size of the maze. Since mazes are square, the size of the maze
     * is the number of cells in either dimension (width or height).
     *
     * @return the size of the maze.
     */
    @Override
    public int size()
    {
        return size;
    }


    /**
     * Tries to find a solution to the maze. If a solution is found, it should
     * be returned as a string that contains the coordinates of each cell in a
     * path that starts at the maze's starting point and leads to the goal,
     * formatted like this (spacing doesn't matter): (0, 0) (0, 1) (1, 1) (2, 1)
     * (2, 2) If the maze has no solution, this method should return null.
     *
     * @return a string representing a solution path if one exists or null.
     */
    @Override
    public String solve()
    {
        solution.push(start);
        this.setCell(solution.peek(), MazeCell.CURRENT_PATH);
        String output = "";

        while (!(solution.peek().equals(goal)))
        {
            Location current = solution.peek();
            if (this.getCell(current.north()) == MazeCell.UNEXPLORED)
            {
                Location north = (Location)current.north();
                solution.push(north);
                this.setCell(north, MazeCell.CURRENT_PATH);
            }
            else if (this.getCell(current.south()) == MazeCell.UNEXPLORED)
            {
                Location south = (Location)current.south();
                solution.push(south);
                this.setCell(south, MazeCell.CURRENT_PATH);
            }
            else if (this.getCell(current.east()) == MazeCell.UNEXPLORED)
            {
                Location east = (Location)current.east();
                solution.push(east);
                this.setCell(east, MazeCell.CURRENT_PATH);
            }
            else if (this.getCell(current.west()) == MazeCell.UNEXPLORED)
            {
                Location west = (Location)current.west();
                solution.push(west);
                this.setCell(west, MazeCell.CURRENT_PATH);
            }
            else
            {
                this.setCell(solution.pop(), MazeCell.FAILED_PATH);
                if (solution.empty())
                {
                    return null;
                }
                current = solution.peek();
            }
        }
        while (!solution.empty())
        {
            output = solution.pop().toString() + output;

        }

        return output;
        
    }
    
    
}
