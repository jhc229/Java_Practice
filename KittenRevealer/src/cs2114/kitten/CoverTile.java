package cs2114.kitten;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;


/**
 * // -------------------------------------------------------------------------
/**
 *  Cover up the kitten with tiles
 *
 *  @author jhc229
 *  @version Oct 17, 2014
 */
public class CoverTile extends RectangleShape
{
    /**
     * Constructor that has the same signature as the one for Kitten.
     * @param left parameter
     * @param top parameter
     * @param right parameter
     * @param bottom parameter
     *
     */
    public CoverTile(float left, float top, float right, float bottom)
    {
        super(left, top, right, bottom);
        setFillColor(Color.red);
    }


}
