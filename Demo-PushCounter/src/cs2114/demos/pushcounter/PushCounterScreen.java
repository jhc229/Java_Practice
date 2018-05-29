package cs2114.demos.pushcounter;

import sofia.app.Screen;
import android.widget.TextView;

//-------------------------------------------------------------------------
/**
 * <p>
 * A very basic example that shows a GUI designed in the GUI layout editor
 * and shows how to respond to clicking a button on the screen.
 * </p><p>
 * Our Screen class is smart enough to find the layout that it should use
 * without having to explicitly specify it. If our class is named
 * "PushCounterScreen", then it will look for a layout in
 * "res/layout/pushcounterscreen.xml" or in
 * "res/layout/push_counter_screen.xml".
 * </p> 
 * 
 * @author  Tony Allevato
 * @version 2012.08.30
 */
public class PushCounterScreen extends Screen
{
	//~ Fields ................................................................

	// Fields that have names matching view/widget IDs in your layout will
	// automatically be assigned references to those widgets so that you can
	// use them in your initialize method (if you have one) and other event
	// handlers.

	private TextView counterLabel;
	
	// A reference to the model for our application, which will be initialized
	// in the initialize() method below.

	private PushCounter counter;
	

	//~ Public methods ........................................................

	// ----------------------------------------------------------
	/**
	 * The initialize method is called when the screen is about to be presented
	 * to the user.
	 * 
	 * Unlike most classes in Java, we usually do not write constructors for
	 * Screen subclasses to do initialization tasks. Instead, we write this
	 * initialize() method, which is called only after the system has
	 * guaranteed that resources we need are available.
	 */
	public void initialize()
	{
		// Create the model that our application will be using.
		
		counter = new PushCounter();

		// Add the controller itself as an observer to the model. Whenever the
		// counter is changed (by clicking the button), the observers will be
		// notified (see the changeWasObserved method below).

		counter.addObserver(this);
	}


	// ----------------------------------------------------------
	/**
	 * This method is called when the button with ID "pushButton" is clicked.
	 * The connection between the button and this method is made automatically
	 * by the system based on the name of the method.
	 */
	public void pushButtonClicked()
	{
		// Notice that we don't explicitly update the contents of the text
		// label here. This happens as part of the observation process in
		// "changeWasObserved".

		counter.incrementCounter();
	}
	
	
	// ----------------------------------------------------------
	/**
	 * This method is called when the button with ID "reset" is clicked.
	 * The connection between the button and this method is made automatically
	 * by the system based on the name of the method.
	 */
	public void resetClicked()
	{
		// Notice that we don't explicitly update the contents of the text
		// label here. This happens as part of the observation process in
		// "changeWasObserved".

		counter.resetCounter();
	}
	
	
	// ----------------------------------------------------------
	/**
	 * Since this object is added as an observer to the model, the model will
	 * call this method whenever it internal calls notifyObservers(). This is
	 * where we are notified that the internal counter has changed and we can
	 * update the label.
	 * 
	 * @param theCounter the instance of PushCounter that had a change occur.
	 *     In our simple example there is only one, so it will always be the
	 *     same as our "counter" field. But if we wanted to observe multiple
	 *     instances of a class, we could use that parameter to differentiate
	 *     them.
	 */
	public void changeWasObserved(PushCounter theCounter)
	{
		counterLabel.setText("Pushes: " + counter.getCounter());
	}
}
