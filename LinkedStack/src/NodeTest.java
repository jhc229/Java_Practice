import student.TestCase;

//-------------------------------------------------------------------------
/**
 * Tests for the {@link Node} class.
 *
 * @author  jhc229
 * @version (2014.10.03)
 */
public class NodeTest
    extends TestCase
{
    //~ Fields ................................................................

    private Node<String> node1;
    private Node<String> node2;
    private Node<String> node3;
    private Node<String> node4;


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Create some new nodes for each test method.
     */
    public void setUp()
    {
        node1 = new Node<String>("node1");
        node2 = new Node<String>("node2");
        node3 = new Node<String>("node3");
        node4 = null;

    }

    /**
     * Test method2 for join()
     */
    public void testJoin()
    {
        Exception thrown = null;
        try
        {
            node3.join(node2);
            node1.join(node2);
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertTrue(thrown instanceof IllegalStateException);
        assertEquals("There is already a node procdeding.",
            thrown.getMessage());
        assertNotNull(thrown);
    }
    /**
     * Test method for join()
     */
    public void testAnotherJoin()
    {
        Exception thrown = null;
        try
        {
            node1.join(node2);
            node1.join(node3);
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertTrue(thrown instanceof IllegalStateException);
        assertEquals("There is already a node following this node.",
            thrown.getMessage());
        node3.join(node4);
        assertNull(node3.next());
    }

    /**
     * Test method for split()
     */
    public void testSplit()
    {
        node1.join(node2.join(node3));
        assertNotNull(node1.next());
        Node<String> nodee = node2.split();
        assertEquals(nodee, node3);
        assertNull(node2.next());
        node1.previous();
    }
}
