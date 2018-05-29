// -------------------------------------------------------------------------
/**
 *  Represents an employee who is paid an hourly wage.
 *
 *  @author  jhc229
 *  @version (place the date here, in this format: yyyy.mm.dd)
 */
public class HourlyEmployee extends Employee
{
    //~ Fields ................................................................
    public HourlyEmployee(String name, double rate)
    {
        super(name, rate);
    }

    //~ Constructor ...........................................................


    //~ Methods ...............................................................
    public double weeklyPay()
    {
        return 40 * super.getPayRate();
    }
}