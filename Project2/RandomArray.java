package cs130.compressor;

import java.util.Random;

public class RandomArray {

    private int numberRows, numberColumns;
    private int[][] grid;

    public RandomArray(int rows, int columns) {
        Random random = new Random();

        numberRows = rows;
        numberColumns = columns;

        grid = new int[numberRows][numberColumns];

        for(int i=0; i<numberRows; i++){
            for(int j=0; j<numberColumns; j++){
                grid[i][j] = Math.abs(random.nextInt()%5);
            }
        }
    }

    public int[][] getGrid(){
        int[][] temp = new int[numberRows][numberColumns];
        for(int i=0; i<numberRows; i++){
            for(int j=0; j<numberColumns; j++){
                temp[i][j] = grid[i][j];
            }
        }
        return temp;
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
