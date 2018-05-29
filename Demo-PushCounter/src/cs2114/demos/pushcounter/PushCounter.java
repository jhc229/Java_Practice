package cs2114.demos.pushcounter;

// -------------------------------------------------------------------------
/**
 * The model that contains the data that represents the push counter (in this
 * simple case, just an integer).
 *
 * Notice that this class extends the sofia.util.Observable class; this allows
 * other classes (such as the controller, PushCounterScreen), to hook in and
 * be notified when changes are made to the model.
 *
 * @author  Tony Allevato
 * @version 2012.08.30
 */
public class PushCounter extends sofia.util.Observable
{
    //~ Fields ................................................................

    // The counter that holds the number of times the user clicked the button.
    private int counter = 0;


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Gets the current value of the counter.
     *
     * @return the current value of the counter
     */
    public int getCounter()
    {
        return counter;
    }


    // ----------------------------------------------------------
    /**
     * Increments the counter. If any observers have been added to the model,
     * they will be notified that the counter has changed.
     */
    public void incrementCounter()
    {
        // Update the counter.

        counter++;

        // Notify anyone observing this model that it has been updated.

        notifyObservers();
    }
    
    
    // ----------------------------------------------------------
    /**
     * Resets the counter back to 0. If any observers have been added to the
     * model, they will be notified that the counter has changed.
     */
    public void resetCounter()
    {
        // Reset the counter.

    	counter = 0;
    	
        // Notify anyone observing this model that it has been updated.

    	notifyObservers();
    }
}
