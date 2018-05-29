package cs2114.mazesolver;

import sofia.graphics.ShapeView;
import android.widget.TextView;
import android.widget.Button;

//-------------------------------------------------------------------------
/**
*  This class is to test MazeSolverScreen class.
*
*  @author  (jhc229)
*  @version (10.27.2014)
*/
public class MazeSolverScreenTests
    extends student.AndroidTestCase<MazeSolverScreen>
{
    //~ Fields ................................................................

    private Button drawWalls;
    private Button eraseWalls;
    private Button setStart;
    private Button setGoal;
    private Button solve;
    private ShapeView shapeView;
    private TextView infoLabel;
    private Location loc;
    // This field will store the pixel width/height of a cell in the maze.
    private int cellSize;


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Test cases that extend AndroidTestCase must have a parameterless
     * constructor that calls super() and passes it the screen/activity class
     * being tested.
     */
    public MazeSolverScreenTests()
    {
        super(MazeSolverScreen.class);
    }


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Initializes the text fixtures.
     */
    public void setUp()
    {
        float viewSize =
            Math.min(shapeView.getWidth(), shapeView.getHeight());
        cellSize = (int)(viewSize / 7);
        loc = new Location(1, 1);
    }

    /**
     * test method for draw.
     */
    public void testDrawWall()
    {
        click(drawWalls);
        touchDownCell(1, 1);
        assertEquals(MazeCell.WALL, getScreen().getMaze().getCell(loc));
        touchMoveCell(2, 1);
        loc = new Location(2, 1);
        assertEquals(MazeCell.WALL, getScreen().getMaze().getCell(loc));
    }

    /**
     * test method for erase.
     */
    public void testErase()
    {
        click(drawWalls);
        touchDownCell(1, 1);
        assertEquals(MazeCell.WALL, getScreen().getMaze().getCell(loc));
        touchMoveCell(2, 1);
        loc = new Location(2, 1);
        touchUp();
        assertEquals(MazeCell.WALL, getScreen().getMaze().getCell(loc));
        
        click(eraseWalls);
        touchDownCell(1, 1);
        touchMoveCell(2, 1);
        assertEquals(MazeCell.UNEXPLORED, getScreen().getMaze().getCell(loc));
        
    }
    
    /**
     * test method to check see if starting location changes.
     */
    public void testStart()
    {
        click(setStart);
        clickCell(1, 1);
        assertEquals(loc, getScreen().getMaze().getStartLocation());
    }
    
    /**
     * test method to check see if goal location changes.
     */
    public void testGoal()
    {
        click(setGoal);
        clickCell(1, 1);
        assertEquals(loc, getScreen().getMaze().getGoalLocation());

    }
    
    /**
     * test method for solve button.
     */
    public void testSolve()
    {
        click(solve);
        assertEquals("(0, 0)(0, 1)(0, 2)(0, 3)(0, 4)(0, 5)(0, 6)(1, 6)(1, 5)"
            + "(1, 4)(1, 3)(1, 2)(1, 1)(1, 0)(2, 0)(2, 1)(2, 2)(2, 3)"
            + "(2, 4)(2, 5)(2, 6)(3, 6)(3, 5)(3, 4)(3, 3)(3, 2)(3, 1)"
            + "(3, 0)(4, 0)(4, 1)(4, 2)(4, 3)(4, 4)(4, 5)(4, 6)(5, 6)"
            + "(5, 5)(5, 4)(5, 3)(5, 2)(5, 1)(5, 0)(6, 0)(6, 1)(6, 2)"
            + "(6, 3)(6, 4)(6, 5)(6, 6)", infoLabel.getText());

        getScreen().initialize();
        
        click(setGoal);
        clickCell(2, 0);
        click(drawWalls);
        clickCell(0, 1);
        clickCell(1, 1);
        clickCell(2, 1);
        clickCell(3, 1);
        clickCell(3, 0);
        click(solve);

        assertEquals("(0, 0)(1, 0)(2, 0)", infoLabel.getText());

        getScreen().initialize();
        
        click(drawWalls);
        touchDownCell(0, 1);
        touchMoveCell(1, 1);
        touchMoveCell(2, 1);
        touchMoveCell(3, 1);
        touchMoveCell(4, 1);
        touchMoveCell(5, 1);
        touchMoveCell(6, 1);
        touchUp();
        click(solve);
        assertEquals("No solution was possible", infoLabel.getText());

    }
    //~ Private methods .......................................................

    // ----------------------------------------------------------
    /**
     * Simulates touching down on the middle of the specified cell in the maze.
     */
    private void touchDownCell(int x, int y)
    {
        touchDown(shapeView, (x + 0.5f) * cellSize, (y + 0.5f) * cellSize);
    }


    // ----------------------------------------------------------
    /**
     * Simulates moving the finger instantaneously to the middle of the
     * specified cell in the maze.
     */
    private void touchMoveCell(int x, int y)
    {
        touchMove((x + 0.5f) * cellSize, (y + 0.5f) * cellSize);
    }


    // ----------------------------------------------------------
    /**
     * Simulates clicking the middle of the specified cell in the maze. This is
     * equivalent to calling: touchDownCell(x, y); touchUp();
     */
    private void clickCell(int x, int y)
    {
        touchDownCell(x, y);
        touchUp();
    }
}
