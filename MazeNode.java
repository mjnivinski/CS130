package cs130.MazeStack;

public class MazeNode {
    private int posX, posY;
    private MazeNode next;

    /**
     * singly linked node very simple has bare minimum information
     * @param x stores column
     * @param y stores row
     * @param nextNode stores previous position
     */
    public MazeNode(int x, int y, MazeNode nextNode){
        posX = x;
        posY = y;
        next = nextNode;
    }

    public int getPositionX(){
        return posX;
    }

    public int getPositionY(){
        return posY;
    }

    public void setNext(MazeNode node){
        this.next = node;
    }

    public MazeNode getNext(){
        return this.next;
    }
}
