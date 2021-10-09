package Tetromino;

import java.util.ArrayList;

abstract public class FreeTetromino {
    protected String color;

    protected RotationPosition currentRotationPosition = RotationPosition.noRotation;
    protected enum RotationPosition{
        noRotation, oneQuarterRotation, halfRotation, threeQuarterRotation
    }

    protected ArrayList<TetroSquare> tetroSquares = new ArrayList<TetroSquare>();

    public FreeTetromino(String color){
        this.color = color;
    }

    protected void moveDown(){
        // todo implement functionality
    }

    protected void moveRight(){
        // todo implement functionality
    }

    protected void moveLeft(){
        // todo implement functionality
    }

    abstract void rotate();
}
