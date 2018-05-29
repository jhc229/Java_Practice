package cs2114.demos.pushcounter;

// -------------------------------------------------------------------------
/**
 * Unit tests for the PushCounter class.
 *
 * Remember that testing is best performed in isolation whenever possible. The
 * model should be designed in such a way that it can be used independently of
 * the views and controllers in the application, so that we can test the model
 * without having to start the activity or interact with the GUI.
 *
 * When you're testing a class that doesn't involve an Android activity or GUI
 * interaction (such as your model classes), you should extend the
 * {@code student.TestCase} class, NOT {@code student.AndroidTestCase}.
 *
 * @author  Tony Allevato
 * @version 2011.07.03
 */
public class PushCounterTest extends student.TestCase
{
    //~ Static/instance variables .............................................

    // The model used for testing.
    private PushCounter counter;


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * The setUp method is called before each test method below in order to
     * start each test with fresh copies of the objects being tested. 
     */
    public void setUp()
    {
    	counter = new PushCounter();
    }


    // ----------------------------------------------------------
    /**
     * Tests that the value of the counter is correct when the model is first
     * created.
     */
    public void testInitialValue()
    {
        assertEquals(0, counter.getCounter());
    }


    // ----------------------------------------------------------
    /**
     * Tests the {@link PushCounter#incrementCounter()} method.
     */
    public void testIncrement()
    {
        counter.incrementCounter();
        assertEquals(1, counter.getCounter());

        counter.incrementCounter();
        assertEquals(2, counter.getCounter());
    }
    
    
    // ----------------------------------------------------------
    /**
     * Tests the {@link PushCounter#resetCounter()} method.
     */
    public void testReset()
    {
    	counter.incrementCounter();
    	counter.resetCounter();
    	
    	assertEquals(0, counter.getCounter());
    }
}
