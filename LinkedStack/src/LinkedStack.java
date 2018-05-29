import java.util.EmptyStackException;

//-------------------------------------------------------------------------
/**
 * An implementation of the stack data type that uses a linked chain of
 * {@code Node<E>} objects to store its contents.
 *
 * This is a PARTIAL IMPLEMENTATION that needs completion.
 *
 * @param <E> the type of elements stored in the stack
 *
 * @author Tony Allevato (authored class skeleton)
 * @author  jhc229
 * @version (2014.10.03)
 */
public class LinkedStack<E> implements StackInterface<E>
{
    //~ Fields ...............................................................

    private Node<E> topOfStackRef;


    //~ Constructors .........................................................

    // ----------------------------------------------------------
    /**
     * Constructor
     */
    public LinkedStack()
    {
        topOfStackRef = null;
    }



    //~ Methods ..............................................................

    // ----------------------------------------------------------
    /**
     * Push the item to the top
     * @param item that pushes to the top
     */
    public void push(E item)
    {
        Node<E> newLink = new Node<E>(item);
        topOfStackRef = newLink.join(topOfStackRef);
    }

    /**
     * Pops the item on the top
     */
    public void pop()
    {
        if (topOfStackRef == null)
        {
            throw new EmptyStackException();
        }

        else
        {
            topOfStackRef = topOfStackRef.split();
        }
    }

    /**
     * Return the item on the top without removing it.
     * @return the specified item.
     */
    public E peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return topOfStackRef.data();
        }
    }

    /**
     * Check to see if stack is empty
     * @return true if it's empty.
     */
    public boolean isEmpty()
    {
        return topOfStackRef == null;
    }
}
