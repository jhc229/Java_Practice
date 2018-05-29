import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

//-------------------------------------------------------------------------
/**
 * Tests for the {@link ArrayStack} class.
 *
 * @author jhc229
 * @version (2014.10.31)
 */
public class ArrayStackTest
    extends TestCase
{
    //~ Instance/static variables .............................................

    private Stack<String> stack;
    private Iterator<String> iterators;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Create a new test class
     */
    public ArrayStackTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Creates a brand new, empty stack for each test method.
     */
    public void setUp()
    {
        stack = new ArrayStack<String>();
    }

    // ----------------------------------------------------------
    /**
     * Test the push() method.
     */
    public void testPush()
    {
        stack.push("hello");
        assertEquals(1, stack.size());
        assertEquals("hello", stack.top());

        stack.push("goodbye");
        assertEquals(2, stack.size());
        assertEquals("goodbye", stack.top());
    }


    // ----------------------------------------------------------
    /**
     * Test the pop() method.
     */
    public void testPop()
    {
        String word = "hello";
        stack.push(word);
        assertEquals(1, stack.size());

        stack.pop();

        // After removal, make sure the inserted object is no longer there.
        assertEquals(0, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Test the topAndPop() method.
     */
    public void testTopAndPop()
    {
        String word = "hello";
        stack.push(word);

        // Use assertSame() to ensure the specific object added is the
        // one returned here
        assertSame(word, stack.topAndPop());

        // After removal, make sure the inserted object is no longer there.
        assertEquals(0, stack.size());
    }


    // ----------------------------------------------------------
    /**
     * Test clear() with multiple values in the stack.
     */
    public void testRemove3()
    {
        String word1 = "hello";
        stack.push(word1);
        String word2 = "goodbye";
        stack.push(word2);
        assertEquals(2, stack.size());

        stack.clear();
        assertEquals(0, stack.size());
    }
    
    /**
     * Test method for stackIterator()
     * 
     */
    public void testStackIterator()
    {
        stack.push("0");
        stack.push("00");
        iterators = stack.iterator();
        assertEquals(2, stack.size());
    }
    
    /**
     * Test method for hasNext().
     */
    public void testHasNext()
    {
        stack.push("0");
        stack.push("00");
        stack.push("000");
        iterators = stack.iterator();
        assertTrue(iterators.hasNext());

    }
    /**
     * Test method for next().
     */
    public void testNext()
    {
        stack.push("0");
        stack.push("00");
        stack.push("000");
        iterators = stack.iterator();
        assertEquals("000", iterators.next());
        assertEquals("00", iterators.next());

        Exception occurred = null;
        try
        {
            iterators.next();
            iterators.next();
        }
        catch (Exception exception)
        {
            occurred = exception;
        }
        assertNotNull(occurred);
        assertTrue(occurred instanceof NoSuchElementException);
        assertEquals("No elements left to process.", occurred.getMessage());

    }
    
    /**
     * Test method for remove().
     */
    public void testRemove()
    {
        stack.push("0");
        stack.push("00");
        iterators = stack.iterator();
        iterators.next();
        iterators.remove();
        assertEquals("0", iterators.next());
        Exception occurred = null;
        try
        {
            iterators.remove();
            iterators.remove();
        }
        catch (Exception exception)
        {
            occurred = exception;
        }
        assertNotNull(occurred);
        assertTrue(occurred instanceof IllegalStateException);
        assertEquals("Error found", occurred.getMessage());

    }
   

    /**
     * Test method for remove2().
     * 
     */
    public void testRemove2()
    {
        stack.push("0");
        stack.push("00");
        iterators = stack.iterator();
 
        Exception occurred = null;
        try
        {
            iterators.remove();
        }
        catch (Exception exception)
        {
            occurred = exception;
        }
        assertNotNull(occurred);
        assertTrue(occurred instanceof IllegalStateException);
        assertEquals("Error found", occurred.getMessage());
    }


    /**
     * Test method for maximumCapacity()
     * 
     */
    public void testExpandCapactiy()
    {
        stack.push("0");
        stack.push("00");
        stack.push("000");
        stack.push("0000");
        stack.push("00000");
        stack.push("000000");
        stack.push("0000000");
        stack.push("00000000");
        stack.push("000000000");
        stack.push("0000000000");
        stack.push("00000000000");
        assertEquals("00000000000", stack.top());
    }

}
