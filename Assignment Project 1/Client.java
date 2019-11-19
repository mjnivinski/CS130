package cs130.NLargest;

import java.io.*;
import java.util.Random;

public class Client {
    public static void main(String args[]) throws IOException {

        runFinder("array1", "array2");

    }

    //Finds every possible N value in any two given arrays received from separate text files
    //Prints them to the command line Largest to Smallest
    public static void runFinder(String filename1, String filename2) throws FileNotFoundException {
        Reader reader1 = new Reader(filename1);
        Reader reader2 = new Reader(filename2);

        int[] array1 = reader1.getNumbers();
        int[] array2 = reader2.getNumbers();

        NLargest largest = new NLargest(array1, array2);

        for(int i=1; i<=array1.length + array2.length; i++){
            System.out.println(largest.findLargestN(i));
        }
    }
}
