package cs2114.demos.pushcounter;

import android.widget.TextView;
import android.widget.Button;

// -------------------------------------------------------------------------
/**
 * An example test case that shows how to test a custom screen class. Note
 * that this test case is not intended to be complete. Instead, it provides
 * an example of just one test method, nothing more. A real test set for the
 * activity would probably exercise all of its features more completely.
 *
 * @author  Tony Allevato
 * @version 2011.07.03
 */
public class PushCounterScreenTest
    extends student.AndroidTestCase<PushCounterScreen>
{
    //~ Static/instance variables .............................................

    // The test case class will automatically fill in any fields that
	// represent widgets/views based on their type and name, just like they do
	// in your screen class.

    private Button pushButton;
    private TextView counterLabel;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * This constructor is required by Android's unit testing framework. Simply
     * declare a no-argument constructor in your test class and call the
     * superclass constructor, passing it the class that represents the
     * screen that you are testing.
     */
    public PushCounterScreenTest()
    {
        super(PushCounterScreen.class);
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * A simple example of a test method for exercising PushCounterScreen.
     */
    public void testPushButton()
    {
        // You can simulate actions in your activity's GUI, such as clicking
        // a button:

        click(pushButton);
        click(pushButton);

        // And then check the state of your widgets:

        assertEquals("Pushes: 2", counterLabel.getText());
    }


    // Place other test methods here...
}
