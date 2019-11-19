package cs130.NLargest;

import java.util.Random;

//This Class is used to create massive lists of random numbers, to be used to test the maximum speed of the algorithm
public class RandomArray {

    public RandomArray(){

    }

    public int[] getArray(int size){
        Random random = new Random();
        int[] array = new int[size];
        for(int i=0; i<size; i++){
            array[i] = Math.abs(random.nextInt());
        }
        QuickSorter sorter = new QuickSorter();
        sorter.quickSort(array);
        return array;
    }
}
