// -------------------------------------------------------------------------
/**
 *  Represents an employee in a company or business.
 *
 *  @author  Your name (pid)
 *  @version (place the date here, in this format: yyyy.mm.dd)
 */
public abstract class Employee implements MeetingParticipant
{
    //~ Fields ................................................................

    private String name;        // The employee's name.
    private double payRate;     // The employee's pay rate.


    //~ Constructor ...........................................................

    public Employee(String name, double rate)
    {
        this.name = name;
        payRate = rate;
    }

    //~ Methods ...............................................................

    // ----------------------------------------------------------
    public abstract double weeklyPay();

    /**
     * Gets the employee's name.
     * @return the employee's name
     */
    public String getName()
    {
        return name;
    }


    // ----------------------------------------------------------
    /**
     * Gets the pay rate.
     * @return the pay rate
     */
    public double getPayRate()
    {
        return payRate;
    }

    public String meetWith(MeetingParticipant otherParticipant)
    {
        return name + " is meeting with " + otherParticipant.getName();
    }
}
