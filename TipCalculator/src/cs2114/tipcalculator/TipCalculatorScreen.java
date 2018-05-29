package cs2114.tipcalculator;

import android.widget.EditText;
import android.widget.TextView;
import sofia.app.Screen;

// -------------------------------------------------------------------------
/**
 * This handles GUI events.
 *
 * @author jhc229
 * @version (2014.09.12)
 */
public class TipCalculatorScreen
    extends Screen
{

    private TipCalculator tipCalc;

    private EditText      amountOfBill;
    private TextView      tipAmount;


    // ~ Public methods ........................................................
    /**
     * The initialize method is called when the screen is about to be presented
     * to the user. Unlike most classes in Java, we usually do not write
     * constructors for Screen subclasses to do initialization tasks. Instead,
     * we write this initialize() method, which is called only after the system
     * has guaranteed that resources we need are available.
     */
    public void initialize()
    {
        tipCalc = new TipCalculator();
        tipCalc.addObserver(this);
        tipCalc.setTipRate(0.15);
    }


    /**
     * Checks the 15% tip when clicked.
     */
    public void tip15Clicked()
    {
        tipCalc.setTipRate(0.15);
    }


    /**
     * Checks the 18% tip when clicked.
     */
    public void tip18Clicked()
    {
        tipCalc.setTipRate(0.18);
    }


    /**
     * Checks the 20% tip when clicked.
     */
    public void tip20Clicked()
    {
        tipCalc.setTipRate(0.20);
    }


    /**
     * Checks the 20% tip when clicked.
     */
    public void amountOfBillEditingDone()
    {
        double amtBill = Double.parseDouble(amountOfBill.getText().toString());
        tipCalc.setAmountOfBill(amtBill);
    }


    /**
     * To respond to the change notifications.
     *
     * @param newTip
     *            the instance of TipCalculator that had a change occur.
     */
    public void changeWasObserved(TipCalculator newTip)
    {
        String a = String.format("%.2f", tipCalc.getTipAmount());
        tipAmount.setText(a);

    }

}
