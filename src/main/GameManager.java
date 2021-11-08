package main;

import main.field.Field;
import main.field.FieldPlace;
import main.tetromino.FreeTetromino;
import main.tetromino.tetrominos.*;

import javax.swing.*;
import java.awt.*;

public class GameManager {
    public static final int SPEED = 200; // delay

    private final CollisionControl collisionControl;
    private final Field field;
    private FreeTetromino freeTetromino;

    private boolean gameOver = false;
    private Timer timer;

    public boolean isGameOver() {
        return gameOver;
    }

    public FieldPlace[][] getFieldPlaces() {
        return field.getFieldPlaces();
    }

    public GameManager(int fieldHeight, int fieldWidth, Timer timer) {
        field = new Field(fieldHeight, fieldWidth);
        collisionControl = new CollisionControl(field);
        this.timer = timer;
        timer.start();
    }

    public GameManager(Field field) {
        this.field = field;
        collisionControl = new CollisionControl(field);
    }

    /**
     * creates a new FreeTetromino and checks if it can be added
     * to the main.field.
     * If new Tetromino can be added, add it and return true.
     * If not, return false (so the game is lost)
     */
    public boolean createNewFreeTetromino() {
        int startXCoordinate = field.getFieldWidth() / 2;
        int startYCoordinate = 0;
        FreeTetromino nextTetromino;

        // create a specific FreeTetromino randomly
        switch ((int) (Math.random() * 7)) {
            case 0:
                nextTetromino = new ITetromino(startXCoordinate, startYCoordinate);
                break;
            case 1:
                nextTetromino = new JTetromino(startXCoordinate, startYCoordinate);
                break;
            case 2:
                nextTetromino = new LTetromino(startXCoordinate, startYCoordinate);
                break;
            case 3:
                nextTetromino = new OTetromino(startXCoordinate, startYCoordinate);
                break;
            case 4:
                nextTetromino = new STetromino(startXCoordinate, startYCoordinate);
                break;
            case 5:
                nextTetromino = new TTetromino(startXCoordinate, startYCoordinate);
                break;
            case 6:
                nextTetromino = new ZTetromino(startXCoordinate, startYCoordinate);
                break;
            default:
                return false;
        }

        if (collisionControl.canAddTetrominoToField(nextTetromino)) {
            freeTetromino = nextTetromino;
            field.fillField(freeTetromino.getTetrominoPositions(), freeTetromino.getColor());
            return true;
        } else {
            gameOver = true;
            timer.stop();
            return false;
        }
    }

    public boolean moveDown() {
        if (collisionControl.canMoveDown(freeTetromino)) {
            field.clearFieldPlaces(freeTetromino.getTetrominoPositions());
            freeTetromino.moveDown();
            field.fillField(freeTetromino.getTetrominoPositions(), freeTetromino.getColor());
            return true;
        }
        return false;
    }

    public boolean moveLeft() {
        if (collisionControl.canMoveLeft(freeTetromino)) {
            field.clearFieldPlaces(freeTetromino.getTetrominoPositions());
            freeTetromino.moveLeft();
            field.fillField(freeTetromino.getTetrominoPositions(), freeTetromino.getColor());
            return true;
        }
        return false;
    }

    public boolean moveRight() {
        if (collisionControl.canMoveRight(freeTetromino)) {
            field.clearFieldPlaces(freeTetromino.getTetrominoPositions());
            freeTetromino.moveRight();
            field.fillField(freeTetromino.getTetrominoPositions(), freeTetromino.getColor());
            return true;
        }
        return false;
    }

    public boolean rotate() {
        if (collisionControl.canRotate(freeTetromino)) {
            field.clearFieldPlaces(freeTetromino.getTetrominoPositions());
            freeTetromino.rotate();
            field.fillField(freeTetromino.getTetrominoPositions(), freeTetromino.getColor());
            return true;
        }
        return false;
    }

    /**
     * Checks for lines full of SquareTetrominos in the main.field and removes them.
     *
     * @return true if full row were found and removed
     */
    public boolean removeFullRow() {
        return field.removeFullRow();
    }

}
