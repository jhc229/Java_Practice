import student.TestCase;

//-------------------------------------------------------------------------
/**
 *  Test cases for the HourlyEmployee class.
 *
 *  @author  jhc229
 *  @version (place the date here, in this format: yyyy.mm.dd)
 */
public class HourlyEmployeeTest extends TestCase
{
    //~ Fields ................................................................
    private HourlyEmployee empl;
    private MeetingParticipant participant;
    // TODO You may want to declare a HourlyEmployee variable here that you
    // will initialize in your setUp method.


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        empl = new HourlyEmployee("Sean Choi", 17.55);
        participant = new HourlyEmployee("Chris", 15.55);
    }

    /**
     * Double takes third argument indicating how close they have to be
     */
    public void testHourlyEmployee()
    {
        assertEquals(702, empl.weeklyPay(), 0.01);
    }

    public void testMeetWith()
    {
        assertEquals("Sean Choi is meeting with Chris", empl.meetWith(participant));
    }


    // TODO Add your test case methods here.
}
