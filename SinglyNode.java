package cs130.Stack.publication;

public class SinglyNode<T> {

    private SinglyNode<T> next;

    private T element;

    public SinglyNode() {
        next = null;
        element = null;
    }

    public SinglyNode(T value) {
        next = null;
        element = value;
    }

    public SinglyNode<T> getNext() {
        return next;
    }

    public void setNext (SinglyNode<T> node) {
        next = node;
    }

    public void setElement(T value) {
        element = value;
    }

    public T getElement () {
        return element;
    }
}
