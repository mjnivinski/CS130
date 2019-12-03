package cs130.compressor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Picture {

    private int numberRows, numberColumns;
    private int[][] grid;

    //this method is used to collect an array of integer arrays from a text file. reused from the maze assignment
    public Picture(String filename) throws FileNotFoundException {
        /**
         * maze constructor scans file
         */
        Scanner scan = new Scanner(new File(filename));
        numberRows = scan.nextInt();
        numberColumns = scan.nextInt();

        grid = new int[numberRows][numberColumns];
        for (int i=0;i<numberRows;i++){
            for (int j=0;j<numberColumns;j++){
                try {
                    grid[i][j] = scan.nextInt();
                } catch (Exception e) {
                    throw new RuntimeException("INVALID MAZE CHECK MAZE FILE");
                }
            }
        }
    }

    public int[][] getGrid(){
        return grid;
    }

    public String toString(){
        String layout ="";
        for(int i=0;i<this.numberRows;i++){
            for(int j=0;j<this.numberColumns;j++){
                layout+=this.grid[i][j] + " ";
            }
            layout +="\n";
        }
        return layout;
    }
}
