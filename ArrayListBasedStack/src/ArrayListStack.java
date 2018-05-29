import java.util.List;
import java.util.ArrayList;
import java.util.EmptyStackException;

// -------------------------------------------------------------------------
/**
 * An implementation of the stack data type that adapts an ArrayList to store
 * its contents. This is a PARTIAL IMPLEMENTATION that needs completion.
 *
 * @param <T>
 *            the type of elements stored in the stack
 * @author Tony Allevato (authored class skeleton)
 * @author jhc229
 * @version (2014.09.26)
 */
public class ArrayListStack<T>
    implements SimpleStack<T>
{
    // ~ Instance/static variables ............................................

    private List<T> aryList;


    // ~ Constructors .........................................................

    // ----------------------------------------------------------
    /**
     * Creates an empty list.
     */
    public ArrayListStack()
    {
        aryList = new ArrayList<T>();
    }


    // ~ Methods ..............................................................

    // ----------------------------------------------------------
    /**
     * Add the item to the list.
     *
     * @param item
     *            that will be added.
     */
    public void push(T item)
    {
        aryList.add(item);
    }


    // ----------------------------------------------------------
    /**
     * Remove the top element.
     */
    public void pop()
    {
        if (size() > 0)
        {
            aryList.remove(aryList.size() - 1);
        }
        else

        {
            throw new EmptyStackException();
        }
    }


    // ----------------------------------------------------------
    /**
     * Removes and returns a top element from the list.
     *
     * @return the top element or null if the list is empty
     */
    public T top()
    {
        if (size() > 0)
        {
            return aryList.get(aryList.size() - 1);

        }
        else
        {
            throw new EmptyStackException();
        }
    }


    // ----------------------------------------------------------
    /**
     * Get the size of the list()
     *
     * @return number of lists in aryList.
     */
    public int size()
    {
        return aryList.size();
    }

    // ----------------------------------------------------------
    /**
     * Check method to see if its empty.
     *
     * @return true if its greater than 0.
     */
    public boolean isEmpty()
    {
        return aryList.size() == 0;
    }
}
