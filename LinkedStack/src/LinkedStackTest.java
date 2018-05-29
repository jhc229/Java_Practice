import java.util.EmptyStackException;
import student.TestCase;

//-------------------------------------------------------------------------
/**
 * Tests for the {@link LinkedStack} class.
 *
 * @author  jhc229
 * @version (2014.10.03)
 */
public class LinkedStackTest
    extends TestCase
{
    //~ Fields ................................................................

    private LinkedStack<Object> newStack;


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Creates a brand new, empty stack for each test method.
     */
    public void setUp()
    {
        newStack = new LinkedStack<Object>();

    }

    /**
     * Test method for isEmpty()
     */
    public void testIsEmpty()
    {
        assertTrue(newStack.isEmpty());
        newStack.push("link");
        assertFalse(newStack.isEmpty());
    }

    /**
     * Test method for pop
     */
    public void testPop()
    {
        Exception thrown = null;
        try
        {
            newStack.pop();
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);

        newStack.push("as");
        newStack.push("bs");
        newStack.push("cs");
        assertEquals("cs", newStack.peek());

        newStack.pop();
        assertEquals("bs", newStack.peek());

        newStack.pop();
        assertEquals("as", newStack.peek());

        newStack.push("ad");
        assertEquals("ad", newStack.peek());

    }

    /**
     * test method for testPeek()
     */
    public void testPeek()
    {
        Exception thrown = null;
        try
        {
            newStack.peek();
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);

    }
}
