package cs130.Stack.publication;


public interface StackADT<T> {
    /**
     * Adds element to start or top of this stack
     * @param element
     */
    public void push(T element);

    /**
     * Removes and returns top of stack if it exists
     * @return element removed from stack
     */
    public T pop();

    /**
     * Returns top of stack without removing it
     * @return element on top of stack
     */
    public T peek();

    /**
     * Returns true if stack is empty
     * @return boolean if stack is empty or not
     */
    public boolean isEmpty();

    /**
     * Returns size of stack as integer
     * @return size of stack as integer
     */
    public int size();

    /**
     * Returns a string of all values of the stack
     * @return String of all values of the stack
     */
    public String toString();

}