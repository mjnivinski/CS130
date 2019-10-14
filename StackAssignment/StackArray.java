package cs130.Stack.publication;
import java.util.EmptyStackException;

public class StackArray<T> implements StackADT<T> {


    private T[] stack;
    private int top;
    private final static int LIMIT_SIZE = 1;


    @SuppressWarnings("unchecked")
    public StackArray() {
        this.stack = (T[]) new Object[LIMIT_SIZE];
        this.top = 0;
    }

    private void expandLimit(){
        T[] larger = (T[])(new Object[this.stack.length*2]);
        for (int i=0; i<this.stack.length;i++){
            larger[i] = this.stack[i];
        }
        this.stack = larger;
    }

    @Override
    public void push(T element){
        if(this.size() == this.stack.length) {
            expandLimit();
        }
        this.stack[this.top] = element;
        this.top++;
    }

    @Override
    public T pop(){
        if (isEmpty()){
            throw new RuntimeException("Cannot pop when stack is empty");
        }

        this.top--;
        T popped = this.stack[this.top];
        this.stack[this.top] = null;
        return(popped);
    }

    @Override
    public T peek(){
        if (isEmpty()){
            throw new RuntimeException("Cannot peek when stack is empty");
        }
        return this.stack[this.top-1];
    }

    @Override
    public boolean isEmpty(){
        return this.top == 0;
    }

    @Override
    public int size(){
        return this.top;
    }

    @Override
    public String toString(){
        String elements = "[";
        for(int i=top-1; i>=0; i--){
            if(i!=0){
                elements+=this.stack[i] + ",";
            }
            else elements+=this.stack[i];
        }

        elements += "]";
        return elements;
    }
}
