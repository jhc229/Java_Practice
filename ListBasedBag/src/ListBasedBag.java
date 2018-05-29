import java.util.Random;
import java.util.ArrayList;
import java.util.List;

//-------------------------------------------------------------------------
/**
 * This class represents an implementation of a bag collection
 * that internally uses an ArrayList to hold the items.
 *
 * This is a PARTIAL IMPLEMENTATION that needs completion.
 *
 * @param <T> The type of items this bag will hold.
 *
 * @author John Lewis, Tony Allevato (authored class skeleton)
 * @author jhc229
 * @version (2014.09.19)
 */
public class ListBasedBag<T>
    implements Bag<T>
{
    //~ Instance/static variables .............................................

    // The default initial capacity of the bag
    private static final int DEFAULT_CAPACITY = 100;

    // A single random number generator shared by all bags
    private static Random rand = sofia.util.Random.generator();

    // You write the declaration for this field:
    private List<T> contents;  // the bag contents


    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates an empty bag using the default capacity.
     */
    public ListBasedBag()
    {
        this(DEFAULT_CAPACITY);
    }


    // ----------------------------------------------------------
    /**
     * Creates an empty bag using the specified capacity.
     * @param initialCapacity this sets specific capacity.
     */
    public ListBasedBag(int initialCapacity)
    {
        contents = new ArrayList<T>(initialCapacity);
    }

    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Adds the specified element to the bag.
     *
     * @param element item to be added
     * @precondition parameter element is not null
     */
    public void add(T element)
    {
        contents.add(element);
    }


    // ----------------------------------------------------------
    /**
     * Removes and returns the specified element from the bag.  If multiple
     * copies of the same element appear in the bag, only one is removed.
     *
     * @param target item to be removed
     * @return the item removed or null if not found
     * @precondition parameter target is not null
     * @postcondition returned value x.equals(target)
     */
    public T remove(T target)
    {

        // The ArrayList class already provides two remove methods: one
        // that takes a numeric position (which you should use here), and
        // another that takes an object and searches for it (which you
        // may not use).  Implement this method by writing your own
        // loop (that is, without calling contains() or indexOf() on contents)
        // to find where the target is, then remove it by position using
        // the remove() method provided by the list.

        for (T bookList : contents)
        {
            if (bookList.equals(target))
            {
                contents.remove(bookList);
                return bookList;
            }
        }
        return null;
    }


    // ----------------------------------------------------------
    /**
     * Removes and returns a random element from the bag.
     *
     * @return the element removed or null if the bag is empty
     */
    public T removeRandom()
    {

        rand = new Random();
        if (size() > 0)
        {
            int selection = rand.nextInt(size());
            return contents.remove(selection);
        }
        else
        {
            return null;
        }
    }


    // ----------------------------------------------------------
    /**
     * Determines if the bag contains the specified element.
     *
     * @param target element to be found
     * @return true if target is in the collection, false otherwise
     * @precondition parameter target is not null
     */
    public boolean contains(T target)
    {

        for (T bookList : contents)
        {
            if (bookList.equals(target))
            {
                return true;
            }
        }
        return false;

        // The ArrayList class already provides this method, but you need
        // to implement it from scratch (that is, without calling
        // contains() or indexOf() on contents) by writing your own loop.
    }


    // ----------------------------------------------------------
    /**
     * Determines if the bag contains no elements.
     *
     * @return true if collection is empty, false otherwise
     */
    public boolean isEmpty()
    {
        if (contents.size() > 0)
        {
            return false;
        }
        return true;
    }


    // ----------------------------------------------------------
    /**
     * Determines the number of elements currently in the bag.
     *
     * @return the number of elements in the bag
     */
    public int size()
    {
        return contents.size();
    }


    // ----------------------------------------------------------
    /**
     * Returns a string representation of this bag.  A bag's string
     * representation is written as a comma-separated list of its
     * contents (in some arbitrary order) surrounded by curly braces,
     * like this:
     * <pre>
     * {52, 14, 12, 119, 73, 80, 35}
     * </pre>
     * <p>
     * An empty bag is simply {}.
     * </p>
     *
     * @return a string representation of the bag and its contents
     */
    public String toString()
    {
        String toStr = "";
        if (size() == 1)
        {
            toStr = contents.get(0).toString();
            return "{" + toStr + "}";
        }
        if ( size() > 0)
        {
            for (int i = 0; i < size(); i++)
            {
                toStr += contents.get(i).toString() + ", ";
            }
            return "{" + toStr + "}";
        }
        else
        {
            return "{}";
        }
        // The ArrayList class provides a different toString() that doesn't
        // use the same format.  You need to implement yours from scratch
        // (that is, without calling toString() on contents)

    }
}
