package cs130.compressor;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class Client {
    public static void main(String args[]) throws FileNotFoundException {
        Picture picture = new Picture("toBeCompressed.txt");
        System.out.println(picture.toString());

        Compressor compressor = new Compressor(picture.getGrid());

        int[][] array = compressor.compress();
        System.out.println(compressor.toString());

        array = compressor.decompress(array);

        System.out.println(compressor.toString(array));



        //testing randomized larger arrays. not necessarily good for compression. but used to check and see if the algorithm works
        RandomArray random = new RandomArray(50, 1000);

        int[][] randomArray = random.getGrid();

        System.out.println("size of array before compression: " + elementCount(randomArray));

        compressor = new Compressor(randomArray);
        int[][] randomArrayCompressed = compressor.compress();

        System.out.println("size of array after compression: " + elementCount(randomArrayCompressed));

        int[][] randomArrayDecompressed = compressor.decompress(randomArrayCompressed);

        System.out.println("size of array after decompression: " + elementCount(randomArrayDecompressed));

        System.out.println(arrayChecker(randomArray, randomArrayDecompressed));


    }

    //used for testing before and after the entire compression process
    public static boolean arrayChecker(int[][] array1, int[][] array2){
        if(array1.length != array2.length) return false;
        for(int i=0; i<array1.length; i++){
            if(array1[i].length != array2[i].length) return false;
            for(int j=0; j<array1[i].length; j++){
                if(array1[i][j] != array2[i][j]) return false;
            }
        }
        return true;
    }

    //counts number of elements in any array for testing purposes
    public static int elementCount(int[][] array){
        int count = 0;
        for(int i=0; i<array.length; i++){
            count+=array[i].length;
        }
        return count;
    }
}