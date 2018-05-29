import org.apache.xalan.xsltc.runtime.Node;


public class sdads<String> implements StackInterface<String>
{
    public sdads()
    {
    Node<String> head = new Node<String>("A");
    Node<String> b = new Node<String>("B");
    Node<String> c = new Node<String>("C");
    }

    public static void main(String[] args) {
    head.setNext(c);
    b.setNext(c);
    head.setNext(b);
    }
}
