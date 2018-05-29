import student.TestCase;

//-------------------------------------------------------------------------
/**
 *  Test cases for the SalariedEmployee class.
 *
 *  @author  jhc229
 *  @version (place the date here, in this format: yyyy.mm.dd)
 */
public class SalariedEmployeeTest extends TestCase
{
    //~ Fields ................................................................

    private SalariedEmployee salEmp;
    // TODO You may want to declare a SalariedEmployee variable here that you
    // will initialize in your setUp method.


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        salEmp = new SalariedEmployee("Sean Choi", 17.55);
    }

    public void testSalariedEmployee()
    {
        assertEquals(17.55, salEmp.weeklyPay(), 0.01);
    }

    public void testEmployeeName()
    {
        assertEquals("Sean Choi", salEmp.getName());

    }
}
