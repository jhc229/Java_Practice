package cs2114.kitten;

import sofia.graphics.Color;
import sofia.app.ShapeScreen;

/**
 * // -------------------------------------------------------------------------
/**
 *  Screen Class for Kitten.
 *
 *  @author jhc229
 *  @version Oct 17, 2014
 */
public class KittenScreen extends ShapeScreen
{
    private static final int GRID_SIZE = 8;

    /**
     * Constructor class.
     */
    public void initialize()
    {
        Kitten obj = new Kitten(0, 0, getWidth(), getHeight());
        add(obj);
        addingTiles();
    }

    /**
     * Adding Tiles.
     */
    public void addingTiles()
    {
        float tileWidth = getWidth() / GRID_SIZE;
        float tileHeight = getHeight() / GRID_SIZE;

        for (int i = 0; i < GRID_SIZE; i++)
        {
            for (int j = 0; j < GRID_SIZE; j++)
            {
                CoverTile tile = new CoverTile(i * tileWidth, j * tileHeight,
                    (i + 1) * tileWidth, (j + 1) * tileHeight);
                if ((i + j) % 2 == 0)
                {
                    tile.setFillColor(Color.red);
                }
                else
                {
                    tile.setFillColor(Color.black);
                }
                add(tile);
            }
        }
    }


    /**
     * User touches that shape, then the movement is locked.
     *
     * @param x x--coordinate of the screen touched.
     * @param y y-coordinate of the screen touched.
     */
    public void onTouchDown(float x, float y)
    {
        processTouch(x, y);
    }


    /**
     * Called when the user moves his or her finger on the screen.
     *
     * @param x x--coordinate of the screen touched.
     * @param y y-coordinate of the screen touched.
     */
    public void onTouchMove(float x, float y)
    {
        processTouch(x, y);
    }


    /**
     * Touch handling method.
     *
     * @param x x--coordinate of the screen touched.
     * @param y y-coordinate of the screen touched.
     */
    private void processTouch(float x, float y)
    {
        CoverTile newTile =
            getShapes().locatedAt(x, y).withClass(CoverTile.class).front();

        if (newTile != null)
        {
            newTile.animate(1000).rotation(360).alpha(0).removeWhenComplete()
                .play();
        }
    }

    /**
     * Given Secret code.
     * @return Secret code.
     */
    public static String secretCode()
    {
        return "BEEMO";
    }

}
