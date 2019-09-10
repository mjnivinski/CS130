package cs130.Stack.publication;

public class Test {
    public static void main(String args[]){
        System.out.println("Hello World");

        StackArray theStack = new StackArray();
        //theStack.pop();
        String stackarino = "";
        for(int i=0; i<100; i++){
            stackarino+=i + " ";
        }
        System.out.println(stackarino);
        for(int i=0; i<100; i++){
            theStack.push(i);
        }
        System.out.println(theStack.toString());
        System.out.println(theStack.size());

        StackLinked theStacks = new StackLinked();
        //theStack.pop();
        for(int i=0; i<100; i++){
            theStacks.push(i);
        }
        System.out.println(theStacks.toString());
        System.out.println(theStacks.size());
    }
}
