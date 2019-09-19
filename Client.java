package cs130.MazeStack;

import java.io.FileNotFoundException;

public class Client {
    public static void main(String args[]) throws FileNotFoundException {
        /**
         * grabs the maze from the file, solves it, then outputs solved maze showing the path taken and the positions visited
         * 0  is an untraversable position
         * 1 is a traversable position
         * 2 is an already visited position but not on the path
         * 3 is the path taken
         */
        Maze maze = new Maze("maze.txt");
        maze.solveMaze();
        System.out.println(maze.toString());
    }
}
