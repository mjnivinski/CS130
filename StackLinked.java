package cs130.Stack.publication;

public class StackLinked<T> implements StackADT<T> {

    private int count;

    private SinglyNode<T> top;

    public StackLinked() {
        count = 0;
        top = null;
    }

    public void push (T element){
        SinglyNode<T> node = new SinglyNode<T> (element);
        node.setNext(top);
        top = node;
        count++;
    }

    public T pop() {
        T element = top.getElement();
        top = top.getNext();
        count--;
        return element;
    }

    public T peek() {
        T element = top.getElement();
        top = top.getNext();
        count--;
        return element;
    }

    public int size (){
        return count;
    }

    public boolean isEmpty() {
        return count==0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        SinglyNode<T> pt = top;
        while(pt!=null) {
            stringBuilder.append(pt.getElement());
            if(pt.getNext() != null) stringBuilder.append(" ");
            pt = pt.getNext();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
