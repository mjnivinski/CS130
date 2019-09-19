package cs130.MazeStack;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

public class Maze {
    /**
     * variable init
     */
    private static final int TRIED = 2;
    private static final int PATH = 3;
    private int numberRows, numberColumns;
    private int[][] grid;

    public Maze(String filename) throws FileNotFoundException{
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

    public void solveMaze(){
        /**
         * Maze is traversed by a singly linked list in the form of a stack
         */
        MazeNode position = new MazeNode(0,0, null);

        this.grid[0][0] = PATH;
        int currentRow = 0;
        int currentColumn = 0;

        /**
         * every direction is checked every time a new position is acquired or when an old position is returned to
         */
        while(this.grid[numberRows-1][numberColumns-1]!=PATH){
            if (validMove("right", currentColumn, currentRow)){
                position = new MazeNode(currentColumn+1, currentRow, position);
            }
            else if(validMove("down", currentColumn, currentRow)){
                position = new MazeNode(currentColumn, currentRow+1, position);

            }
            else if(validMove("left", currentColumn, currentRow)){
                position = new MazeNode(currentColumn-1, currentRow, position);
            }
            else if(validMove("up", currentColumn, currentRow)){
                position = new MazeNode(currentColumn, currentRow-1, position);
            }
            else{
                if(currentColumn==0&&currentRow==0){
                    System.out.println("UNSOLVABLE MAZE");
                    return;
                }
                grid[currentRow][currentColumn] = TRIED;
                position = position.getNext();
            }
            currentColumn = position.getPositionX();
            currentRow = position.getPositionY();
            this.grid[currentRow][currentColumn] = PATH;

            //used for step through with solver
            //System.out.println(this.toString());
        }

    }

    /**
     * ValidMove takes directions from the mazeSolver to check if a direction is valid.
     * @param direction
     * @param x current column location
     * @param y current row location
     * @return true if path direction is valid, false if it is invalid
     */
    private boolean validMove(String direction, int x, int y){
        switch(direction){
            case "right":
                if(this.numberColumns == x+1) return false;
                if(this.grid[y][x+1]==1) return true;
                return false;
            case "down":
                if(this.numberRows == y+1) return false;
                if(this.grid[y+1][x] == 1) return true;
                return false;
            case "left":
                if(x==0) return false;
                if(this.grid[y][x-1]==1) return true;
                return false;
            case "up":
                if(y==0) return false;
                if(this.grid[y-1][x] == 1) return true;
                return false;
        }
        return false;
    }

    /**
     * toString method
     * @return prints a readable version of the maze current or completed.
     */
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