package tetromino;

public class TetrominoSquare {
    private int xCoordinate;
    private int yCoordinate;
    private boolean root = false;

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setCoordinates(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public boolean isRoot() {
        return root;
    }

    public TetrominoSquare(int x, int y, boolean isRoot) {
        xCoordinate = x;
        yCoordinate = y;
        this.root = isRoot;
    }

    public TetrominoSquare(int x, int y) {
        xCoordinate = x;
        yCoordinate = y;
    }

    public void incrementX() {
        xCoordinate++;
    }

    public void decrementX() {
        xCoordinate--;
    }

    public void incrementY() {
        yCoordinate++;
    }
}
