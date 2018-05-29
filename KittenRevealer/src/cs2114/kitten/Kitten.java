package cs2114.kitten;

import sofia.graphics.RectangleShape;

/**
 * // -------------------------------------------------------------------------
/**
 *  These represent the pixel locations of the sides of the shape on the screen.
 *
 *  @author jhc229
 *  @version Oct 17, 2014
 */
public class Kitten extends RectangleShape
{
    /**
     * Constructor for the Kitten.
     * @param left parameter
     * @param top parameter
     * @param right parameter
     * @param bottom parameter
     */
    public Kitten(float left, float top, float right, float bottom)
    {
        super(left, top, right, bottom);
        setImage("kitten");
    }
}
