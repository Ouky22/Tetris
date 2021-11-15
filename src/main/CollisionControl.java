package main;

import main.field.Field;
import main.tetromino.FreeTetromino;

import java.util.Arrays;

public class CollisionControl {
    Field field;

    public CollisionControl(Field field) {
        this.field = field;
    }

    public boolean canAddTetrominoToField(FreeTetromino freeTetromino) {
        for (int[] tetroSquarePosition : freeTetromino.getTetrominoPositions()) {
            int xCoordinate = tetroSquarePosition[0];
            int yCoordinate = tetroSquarePosition[1];
            if (field.getFieldPlaces()[yCoordinate][xCoordinate].isTaken())
                return false;
        }
        return true;
    }

    public boolean canMoveDown(FreeTetromino freeTetromino) {
        FreeTetromino tetrominoCopy = freeTetromino.clone();
        tetrominoCopy.moveDown();
        return canMove(freeTetromino, tetrominoCopy);
    }

    public boolean canMoveLeft(FreeTetromino freeTetromino) {
        FreeTetromino tetrominoCopy = freeTetromino.clone();
        tetrominoCopy.moveLeft();
        return canMove(freeTetromino, tetrominoCopy);
    }

    public boolean canMoveRight(FreeTetromino freeTetromino) {
        FreeTetromino tetrominoCopy = freeTetromino.clone();
        tetrominoCopy.moveRight();
        return canMove(freeTetromino, tetrominoCopy);
    }

    public boolean canRotate(FreeTetromino freeTetromino) {
        FreeTetromino tetrominoCopy = freeTetromino.clone();
        tetrominoCopy.rotate();
        return canMove(freeTetromino, tetrominoCopy);
    }

    /**
     * returns true if current freeTetromino can move.
     * There are two cases in which current freeTetromino can't move:
     * 1. FreeTetromino's future position would collide with boundaries of main.field
     * 1. FreeTetromino's future position would collide with other sitting main.tetromino(s)
     */
    private boolean canMove(FreeTetromino currentTetromino, FreeTetromino futureTetromino) {
        for (int[] futureTetroSquarePos : futureTetromino.getTetrominoPositions()) {
            // if the position of a tetrominoSquare of the future main.tetromino has the same position
            // of a tetrominoSquare of the current main.tetromino, then skip collision control, because
            // the position can be taken from the future tetrominoSquare
            boolean isNeighbour = false;
            for (int[] currentTetroSquarePos : currentTetromino.getTetrominoPositions()) {
                if (Arrays.equals(currentTetroSquarePos, futureTetroSquarePos)) {
                    isNeighbour = true;
                    break;
                }
            }
            // make collision control
            if (!isNeighbour) {
                int xCoordinate = futureTetroSquarePos[0];
                int yCoordinate = futureTetroSquarePos[1];
                if (xCoordinate < 0 || xCoordinate > field.getFieldWidth() - 1
                        || yCoordinate < 0 || yCoordinate > field.getFieldHeight() - 1
                        || field.getFieldPlaces()[yCoordinate][xCoordinate].isTaken())
                    return false;
            }
        }
        return true;
    }
}
