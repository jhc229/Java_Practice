// -------------------------------------------------------------------------
/**
 *  Represents an employee who is paid a yearly salary.
 *
 *  @author  jhc229
 *  @version (place the date here, in this format: yyyy.mm.dd)
 */
public class SalariedEmployee extends Employee
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................
    public SalariedEmployee(String name, double rate)
    {
        super(name, rate);
    }

    //~ Methods ...............................................................

    public double weeklyPay()
    {
        return super.getPayRate();
    }

    public String meetWith(SalariedEmployee otherParticipant)
    {
        return otherParticipant.getName() + " is joining "
            + this.getName() + " in a conference";
    }

}