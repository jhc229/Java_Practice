package cs2114.mazesolver;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Test case for Location class.
 *
 *  @author Sean
 *  @version Oct 10, 2014
 */
public class LocationTest extends TestCase
{

    private Location testLocation;

    /**
     * setUp initial location coordinates.
     */
    public void setUp()
    {
        testLocation = new Location(0, 0);
    }

    /**
     * Test method for East()
     */
    public void testEast()
    {
        assertEquals(1, testLocation.east().x());
        assertEquals(0, testLocation.east().y());
    }

    /**
     * Test method for north()
     */
    public void testNorth()
    {
        assertEquals(0, testLocation.north().x());
        assertEquals(-1, testLocation.north().y());
    }


    /**
     * Test method for south()
     */
    public void testSouth()
    {
        assertEquals(0, testLocation.south().x());
        assertEquals(1, testLocation.south().y());
    }


    /**
     * Test method for west()
     */
    public void testWest()
    {
        assertEquals(-1, testLocation.west().x());
        assertEquals(0, testLocation.west().y());
    }

    /**
     * Test method for Equals method.
     */
    public void testEqualsObject()
    {
        Location testL = new Location(1, 1);
        Location testLL = new Location(0, 1);
        Location testLLL = new Location(1, 0);
        Location testLLLL = new Location(0, 0);
        String string = "string";
        assertFalse(testLocation.equals(testL));
        assertFalse(testLocation.equals(testLL));
        assertFalse(testLocation.equals(testLLL));
        assertTrue(testLocation.equals(testLLLL));
        assertFalse(testLocation.equals(string));
    }

    /**
     * Test method for toString method.
     */
    public void testToString()
    {
        assertEquals("(0, 0)", testLocation.toString());
    }

}
