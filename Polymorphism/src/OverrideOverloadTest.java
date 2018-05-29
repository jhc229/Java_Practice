import student.*;

//-------------------------------------------------------------------------
/**
 *  Unit tests to highlight the difference between overriding and
 *  overloading in the {@link Employee} and {@link SalariedEmployee}
 *  classes.
 *
 *  @author  Stephen Edwards (stedwar2)
 *  @version 2010.09.01
 */
public class OverrideOverloadTest
    extends TestCase
{
    //~ Instance/static fields ...............................................

    private SalariedEmployee karen1;
    private SalariedEmployee chris1;

    private Employee karen2;
    private Employee chris2;


    //~ Constructor ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new object.
     */
    public OverrideOverloadTests()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        karen1 = new SalariedEmployee("Karen", 1500.0d);
        karen2 = karen1;

        chris1 = new SalariedEmployee("Chris", 1450.0d);
        chris2 = chris1;
    }


    // ----------------------------------------------------------
    /**
     * Test meetings between Karen and Chris.
     */
    public void testMeetWith()
    {
        // Identify which version of meetWith() (from Employee or
        // from SalariedEmployee) will be called, and based on that,
        // determine the value produced in each of the calls below. Fill in
        // the blanks in each assertEquals() with the values you expect. Then,
        // after running this test, examine the actual results.  Correct
        // any mistaken expected values you wrote, and then answer the
        // questions that appear in comments after each assertion.

        String result1 = karen1.meetWith(chris1);

        assertEquals("Chris is joining Karen in a conference", result1);

        // 1) Which version of meetWith() (Employee or SalariedEmployee)
        //    was called?
        //    "Chris is joining Karen in a conference.

        // 2) Explain WHY:
        //

        String result2 = karen1.meetWith(chris2);

        assertEquals("Karen is meeting with Chris", result2);

        // 3) Which version of meetWith() (Employee or SalariedEmployee)
        //    was called?
        //      "Karen is meeting with Chris"

        // 4) Explain WHY:
        //  Since the argument for meetWith() in Karen1 (SalareidEmployee class)
        // takes argument type of SalariedEmployee. Therefore, super class will
        // take argument in the Employee class.

        String result3 = karen2.meetWith(chris1);

        assertEquals("Karen is meeting with Chris", result3);

        // 5) Which version of meetWith() (Employee or SalariedEmployee)
        //    was called?
        //    ___________

        // 6) Explain WHY:
        //

        String result4 = karen2.meetWith(chris2);

        assertEquals("Karen is meeting with Chris", result4);

        // 7) Which version of meetWith() (Employee or SalariedEmployee)
        //    was called?
        //    ___________

        // 8) Explain WHY:
        //
    }


}