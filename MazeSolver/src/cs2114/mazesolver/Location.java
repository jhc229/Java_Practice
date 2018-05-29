package cs2114.mazesolver;

/**
 * // -------------------------------------------------------------------------
/**
 *  X and Y coordinates of the location.
 *
 *  @author jhc229
 *  @version Oct 1, 2014
 */
public class Location implements ILocation
{

    private int x;
    private int y;

    /**
     * A constructor that takes two integers, representing
     * the x- and y-coordinates of the location.
     * @param x coordinate of the location.
     * @param y coordinate of the location.
     */
    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets a new location that represents the (x, y) coordinates
     * one cell east of this location.
     * @return a new location coordinates one cell east of this location
     */
    @Override
    public ILocation east()
    {
        Location eLocation = new Location(x + 1, y);
        return eLocation;
    }

    /**
     * Gets a new location that represents the (x, y) coordinates
     * one cell north of this location.
     * @return a new location coordinates one cell north of this location
     */
    @Override
    public ILocation north()
    {
        Location nLocation = new Location(x, y - 1);
        return nLocation;
    }

    /**
     * Gets a new location that represents the (x, y) coordinates
     * one cell south of this location.
     * @return a new location coordinates one cell south of this location
     */
    @Override
    public ILocation south()
    {
        Location sLocation = new Location(x, y + 1);
        return sLocation;
    }

    /**
     * Gets a new location that represents the (x, y) coordinates
     * one cell west of this location.
     * @return a new location coordinates one cell west of this location
     */
    @Override
    public ILocation west()
    {
        Location wLocation = new Location(x - 1, y);
        return wLocation;
    }

    /**
     * Gets the x-coordinate of the location.
     * @return the x-coordinate of the location
     */
    @Override
    public int x()
    {
        return x;
    }

    /**
     * Gets the y-coordinate of the location.
     * @return the y-coordinate of the location
     */
    @Override
    public int y()
    {
        return y;
    }

    /**
     * Method that returns true if the object passed
     * to it is another Location that has the same x- and y-coordinates.
     * @param location is the new location.
     * @return true if the object has the same x- and y-coordinates.
     */
    public boolean equals(Object location)
    {
        if (location instanceof Location)
        {
            Location newLocation = (Location) location;
            return newLocation.y() == this.y()
                && newLocation.x() == this.x();

        }
        return false;

    }

    /**
     * Return x and y coordinate in string.
     * @return the coordinate formatted like "(x, y)"
     */
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
}