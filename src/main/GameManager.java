package main;

import main.field.Field;
import main.field.FieldPlace;
import main.tetromino.FreeTetromino;
import main.tetromino.tetrominos.*;
import main.persistence.PersistenceService;

import javax.swing.*;

public class GameManager {
    public static final int SPEED = 500; // delay

    private final CollisionControl collisionControl;
    private final Field field;
    private FreeTetromino freeTetromino;

    private final PersistenceService persistenceService = new PersistenceService();

    private boolean gameOver = false;
    private int currentScore;
    private int highScore;
    private final Timer timer;

    public boolean isGameOver() {
        return gameOver;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public int getHighScore() {
        return highScore;
    }

    public FieldPlace[][] getFieldPlaces() {
        return field.getFieldPlaces();
    }

    public GameManager(int fieldHeight, int fieldWidth, Timer timer) {
        field = new Field(fieldHeight, fieldWidth);
        collisionControl = new CollisionControl(field);
        this.timer = timer;
        highScore = readHighScore();
        timer.setInitialDelay(10);
        timer.start();
    }

    /**
     * creates a new FreeTetromino and checks if it can be added
     * to the field.
     * If new Tetromino can be added, add it and return true.
     * If not, return false (so the game is over)
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
            if (highScore == currentScore) // only save new highScores
                saveHighScore();
            timer.stop();
            return false;
        }
    }

    /**
     * moveDown can be called from the system or from the player.
     * If called from the player and tetromino can move down,
     * trigger event for redrawing the field (for smoother gameplay)
     */
    public boolean moveDown(boolean fromPlayer) {
        if (collisionControl.canMoveDown(freeTetromino)) {
            field.clearFieldPlaces(freeTetromino.getTetrominoPositions());
            freeTetromino.moveDown();
            field.fillField(freeTetromino.getTetrominoPositions(), freeTetromino.getColor());
            if (fromPlayer)
                timer.restart();
            return true;
        }
        return false;
    }

    public boolean moveLeft() {
        if (collisionControl.canMoveLeft(freeTetromino)) {
            field.clearFieldPlaces(freeTetromino.getTetrominoPositions());
            freeTetromino.moveLeft();
            field.fillField(freeTetromino.getTetrominoPositions(), freeTetromino.getColor());
            timer.restart();
            return true;
        }
        return false;
    }

    public boolean moveRight() {
        if (collisionControl.canMoveRight(freeTetromino)) {
            field.clearFieldPlaces(freeTetromino.getTetrominoPositions());
            freeTetromino.moveRight();
            field.fillField(freeTetromino.getTetrominoPositions(), freeTetromino.getColor());
            timer.restart();
            return true;
        }
        return false;
    }

    public boolean rotate() {
        if (collisionControl.canRotate(freeTetromino)) {
            field.clearFieldPlaces(freeTetromino.getTetrominoPositions());
            freeTetromino.rotate();
            field.fillField(freeTetromino.getTetrominoPositions(), freeTetromino.getColor());
            timer.restart();
            return true;
        }
        return false;
    }

    /**
     * Checks for lines full of SquareTetrominos in the field and removes them.
     * For every row removed the score gets increased
     */
    public void removeFullRows() {
        while (field.removeFullRow()) {
            currentScore += 20;
            if (currentScore > highScore) {
                highScore = currentScore;
            }
        }
    }

    private int readHighScore() {
        return persistenceService.readHighScore();
    }

    private void saveHighScore() {
        persistenceService.saveHighScore(highScore);
    }
}
