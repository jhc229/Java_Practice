/**
 * 
 * @author sean
 *
 */
public class random
{
    
    public static int mystery(int a, int b)
    {
        if (b==1)
        {
            return a;
        }
        else
        {
            return a + mystery(a, b-1);
        }
    }
    
    public void dosomething(int n)
    {
        if(n > 0)
        {
            dosomething(n - 1);
            System.out.print(n);
        }
    }
}
