package Tetromino;

public class TetrominoSquare {
    private int xCoordinate;
    private int yCoordinate;
    private boolean isRoot = false;

    public TetrominoSquare(int x, int y, boolean isRoot){
        xCoordinate = x;
        yCoordinate = y;
        this.isRoot = isRoot;
    }

    public TetrominoSquare(int x, int y){
        xCoordinate = x;
        yCoordinate = y;
    }

    public void incrementX(){
        xCoordinate++;
    }

    public void decrementX(){
        xCoordinate--;
    }

    public void incrementY(){
        yCoordinate++;
    }
}
