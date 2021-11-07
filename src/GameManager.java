import field.Field;
import tetromino.FreeTetromino;
import tetromino.TetrominoColor;
import tetromino.tetrominos.*;

import java.io.IOException;

public class GameManager {
    private final CollisionControl collisionControl;
    private final Field field;
    private FreeTetromino freeTetromino;

    public GameManager(int fieldHeight, int fieldWidth) {
        field = new Field(fieldHeight, fieldWidth);
        collisionControl = new CollisionControl(field);
    }

    public GameManager(Field field) {
        this.field = field;
        collisionControl = new CollisionControl(field);
    }

    /**
     * creates a new FreeTetromino and checks if it can be added
     * to the field.
     * If new Tetromino can be added, add it and return true.
     * If not, return false (so the game is lost)
     */
    public boolean createNewFreeTetromino() {
        int startXCoordinate = field.getFieldWidth() / 2;
        int startYCoordinate = field.getFieldHeight() - 2;
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
     * Checks for lines full of SquareTetrominos in the field and removes them.
     *
     * @return true if full row were found and removed
     */
    public boolean removeFullRow() {
        return field.removeFullRow();
    }

    public void drawField() throws IOException, InterruptedException {
        // clear console
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        // draw field
        for (int i = field.getFieldPlaces().length - 1; i >= 0; i--) {
            for (int k = 0; k < field.getFieldPlaces()[i].length; k++) {
                String color = field.getFieldPlaces()[i][k].getColor();
                if (color != null)
                    System.out.print(color + "O " + TetrominoColor.ANSI_RESET);
                else
                    System.out.print("O ");
            }
            System.out.println();
        }
    }
}
