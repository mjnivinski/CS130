package cs130.NLargest;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Reader {
    private int[] array;
    private final static int LIMIT_SIZE = 10;

    public Reader(String filename) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(filename));
        this.array = new int[LIMIT_SIZE];

        int i = 0;

        do{
            try{
                this.array[i] = scan.nextInt();
            } catch (Exception e) {
                i = -2;
            }

            i++;
            if(i == this.array.length) expandLimit();
        }while(i != -1);

        fixTail();
    }

    public int[] getNumbers() { return this.array; }

    private void expandLimit() {
        int[] larger = new int[this.array.length+1000];
        for (int i=0; i<this.array.length; i++){
            larger[i] = this.array[i];
        }
        this.array = larger;
    }

    private void fixTail(){
        int count=0;
        while(array[count]!=0){
            count++;
        }

        int[] newArray = new int[count];
        for(int i=0; i<count; i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
