import java.util.EmptyStackException;
import student.TestCase;

//-------------------------------------------------------------------------
/**
 * Tests for the {@link ArrayListStack} class.
 *
 * @author jhc229
 * @version (2014.09.26)
 */
public class ArrayListStackTest
    extends TestCase
{
    //~ Instance/static variables .............................................

    private ArrayListStack<String> stack;


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Creates a brand new, empty stack for each test method.
     */
    public void setUp()
    {
        stack = new ArrayListStack<String>();
    }

    /**
     *  Test push method that adds.
     */
    public void testPush()
    {
        stack.push("paosjd");
        stack.push("osjd");
        assertEquals(2, stack.size());
    }

    /**
     * Test pop method that takes out from the top list.
     */
    public void testPop()
    {
        Exception thrown = null;
        try
        {
            stack.pop();
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);

        stack.push("paosjd");
        stack.push("osjd");
        stack.pop();
        assertEquals(1, stack.size());

    }

    /**
     *
     */
    public void testTop()
    {

        Exception thrown = null;
        try
        {
            stack.top();
        }
        catch (Exception exception)
        {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);

        stack.push("paosjd");
        stack.push("osjd");
        assertEquals("osjd", stack.top());
    }

    /**
     * Test method to check the number of elements in the list.
     */
    public void testSize()
    {
        stack.push("paosjd");
        stack.push("osjd");
        assertEquals(2, stack.size());
        stack.pop();
        stack.pop();
        assertEquals(0, stack.size());
    }

    /**
     * Test method to check list available elements.
     */
    public void testIsEmpty()
    {
        stack.push("paosjd");
        stack.push("osjd");
        assertTrue(stack.isEmpty());
        stack.pop();
        stack.pop();
        assertFalse(stack.isEmpty());
    }
}