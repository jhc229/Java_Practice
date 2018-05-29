import student.TestCase;


/**
 * 
 * @author sean
 *
 */
public class randomtest extends TestCase
{

    private random ran;
    
    public void testRandom()
    {
        assertEquals(6, ran.mystery(2, 3));
       // assertEquals(3, ran.mystery(2, 0)); //infinite recursion?

    }
    public void testDosomething()
    {
        System.out.println();

    }
    
}
