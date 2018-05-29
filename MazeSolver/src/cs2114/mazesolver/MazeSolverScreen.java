package cs2114.mazesolver;
import android.widget.TextView;
import sofia.app.ShapeScreen;
import sofia.graphics.Color;
import sofia.graphics.OvalShape;
import sofia.graphics.RectangleShape;


// -------------------------------------------------------------------------
/**
 * This class creates the GUI for the maze solver game.
 * 
 * @author (jhc229)
 * @version (10.27.2014)
 */
public class MazeSolverScreen extends ShapeScreen
{
// ~ Fields ................................................................
// maze to call operations on the model
    private Maze maze;
    private static final int GRID_SIZEE = 7;
    private float mazeSize;
    private OvalShape startLoc;
    private OvalShape goalLoc;
    private boolean drawButton;
    private boolean eraseButton;
    private boolean startButton;
    private TextView infoLabel;


// ~ Public methods.........................................................

    /**
     * create a maze for data manipulation and fill the shapeView with tiles
     */
    public void initialize()
    {
        maze = new Maze(GRID_SIZEE);
        float mazeWidth = getWidth() / GRID_SIZEE;  // 1
        float mazeHeight = getHeight() / GRID_SIZEE; // 1
        mazeSize = Math.min(mazeWidth, mazeHeight);
        
        for (int i = 0; i < GRID_SIZEE; i++)
        {
            for (int j = 0; j < GRID_SIZEE; j++)
            {
                RectangleShape tile = new RectangleShape(i * mazeSize, 
                    j * mazeSize, (i + 1) * mazeSize, (j + 1) * mazeSize);
                tile.setColor(Color.white);
                tile.setFillColor(Color.black);
                this.add(tile);
                
                if (i == 0 && j == 0)
                {
                    startLoc = new OvalShape(mazeSize / 2, mazeSize / 2, 15);
                    startLoc.setFillColor(Color.limeGreen);
                    this.add(startLoc);
                }
                else if (i == (GRID_SIZEE - 1) && j == (GRID_SIZEE - 1))
                {
                    goalLoc = new OvalShape(mazeSize * 6 + (mazeSize / 2), 
                        mazeSize * 6 + (mazeSize / 2), 15);
                    goalLoc.setFillColor(Color.red);
                    this.add(goalLoc);
                }
            }
        }

    }

    /**
     * method to return maze.
     * @return maze
     */
    public IMaze getMaze()
    {
        return maze;
    }

    /**
     * User touches that shape, then the movement is locked.
     *
     * @param x x--coordinate of the screen touched.
     * @param y y-coordinate of the screen touched.
     */
    public void onTouchMove(float x, float y)
    {
        this.processTouch(x, y);
    }


    /**
     * Called when the user moves his or her finger on the screen.
     *
     * @param x x--coordinate of the screen touched.
     * @param y y-coordinate of the screen touched.
     */
    public void onTouchDown(float x, float y)
    {
        this.processTouch(x, y);
    }


    /**
     * Touch handling method.
     *
     * @param x x--coordinate of the screen touched.
     * @param y y-coordinate of the screen touched.
     */
    public void processTouch(float x, float y)
    {
        float cellSize = Math.min(getWidth(), getHeight()) / GRID_SIZEE;
        for (int i = 0; i < GRID_SIZEE; i++)
        {
            for (int j = 0; j < GRID_SIZEE; j++)
            {
                if ((x >= cellSize * i && x < cellSize * (i + 1))
                    && (y >= cellSize * j && y < cellSize * (j + 1)))
                {
                    int xLoc = (int) (x / mazeSize);
                    int yLoc = (int) (y / mazeSize);
                    Location current = new  Location(xLoc, yLoc);
                    
                    if (drawButton)
                    {
                        RectangleShape newTile =
                            getShapes().locatedAt(x, y)
                            .withClass(RectangleShape.class).front();
                        newTile.setFillColor(Color.gray);
                        maze.setCell(current, MazeCell.WALL);
                    }
                    
                    else if (eraseButton)
                    {
                        RectangleShape newTile =
                            getShapes().locatedAt(x, y)
                            .withClass(RectangleShape.class).front();
                        newTile.setFillColor(Color.black);
                        maze.setCell(current, MazeCell.UNEXPLORED);
                    }
                    
                    else if (startButton)
                    {
                        this.remove(startLoc);

                        RectangleShape cell =
                            getShapes().locatedAt(x, y)
                            .withClass(RectangleShape.class)
                                .front();
                        OvalShape newStart = new OvalShape(cell.getX(),
                            cell.getY(), 12);
                        newStart.setColor(Color.limeGreen);
                        startLoc = newStart;
                        this.add(startLoc);

                        maze.setStartLocation(current);
                    }
                    
                    else
                    {
                        this.remove(goalLoc);

                        RectangleShape cell =
                            getShapes().locatedAt(x, y)
                            .withClass(RectangleShape.class)
                                .front();

                        OvalShape newGoal = new OvalShape(cell.getX(), 
                            cell.getY(), 12);
                        newGoal.setColor(Color.red);
                        goalLoc = newGoal;
                        this.add(goalLoc);

                        maze.setGoalLocation(current);
                    }
                }
            }
        }
    }

    /**
     * Set drawButton to true and else false. 
     */
    public void drawWallsClicked()
    {
        drawButton = true;
        eraseButton = false;
        startButton = false;
    }

    /**
     * Set eraseButton to true and else false. 
     */
    public void eraseWallsClicked()
    {
        eraseButton = true;
        drawButton = false;
        startButton = false;
    }

    /**
     * Sets startButton to true and else false. This will switch current start
     * location.
     */
    public void setStartClicked()
    {
        startButton = true;
        drawButton = false;
        eraseButton = false;
    }

    /**
     * Sets goalButton to true and else false. This will switch current goal
     * location.
     */
    public void setGoalClicked()
    {
        startButton = false;
        drawButton = false;
        eraseButton = false;
    }

    /**
     * This method will try to find a solution to the maze and change the color
     * of the cells. Blue indicates the correct path(Current_PATH) and red
     * indicated the wrong path(Failed_PATH).
     */
    public void solveClicked()
    {
        String solution = maze.solve();
        if (solution == null)
        {
            infoLabel.setText("No solution was possible");
        }
        else
        {
            infoLabel.setText(solution);
        }
        
        for (int i = 0; i < GRID_SIZEE; i++)
        {
            for (int j = 0; j < GRID_SIZEE; j++)
            {
                Location currentLoc = new Location(i, j);
                float x = (i * mazeSize + 1);
                float y = (j * mazeSize + 1);
                
                if (maze.getCell(currentLoc).equals(MazeCell.CURRENT_PATH))
                {
                    RectangleShape newTile = getShapes().locatedAt(x, y)
                        .withClass(RectangleShape.class).front();
                    newTile.setFillColor(Color.blue);
                }
                else if (maze.getCell(currentLoc).equals(MazeCell.FAILED_PATH))
                {
                    RectangleShape newTile = getShapes().locatedAt(x, y)
                        .withClass(RectangleShape.class).front();
                    newTile.setFillColor(Color.red);
                }
            }
        }
    }
}
