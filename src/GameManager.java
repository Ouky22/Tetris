import jdk.jshell.spi.ExecutionControl;
import tetromino.FreeTetromino;
import tetromino.tetrominos.*;

public class GameManager {
    private FreeTetromino freeTetromino;

    public boolean createNewFreeTetromino() {
        int startXCoordinate = 0;
        int startYCoordinate = 0;

        if (!canCreateNewFreeTetromino())
            return false;

        // create a specific FreeTetromino randomly
        switch ((int) (Math.random() * 7)) {
            case 0:
                freeTetromino = new ITetromino(startXCoordinate, startYCoordinate);
                return true;
            case 1:
                freeTetromino = new JTetromino(startXCoordinate, startYCoordinate);
                return true;
            case 2:
                freeTetromino = new LTetromino(startXCoordinate, startYCoordinate);
                return true;
            case 3:
                freeTetromino = new OTetromino(startXCoordinate, startYCoordinate);
                return true;
            case 4:
                freeTetromino = new STetromino(startXCoordinate, startYCoordinate);
                return true;
            case 5:
                freeTetromino = new TTetromino(startXCoordinate, startYCoordinate);
                return true;
            case 6:
                freeTetromino = new ZTetromino(startXCoordinate, startYCoordinate);
                return true;
            default:
                return false;
        }
    }

    public boolean moveDown() {
        if (canMoveDown()) {
            freeTetromino.moveDown();
            return true;
        }
        return false;
    }

    public boolean moveLeft() {
        if (canMoveLeft()) {
            freeTetromino.moveLeft();
            return true;
        }
        return false;
    }

    public boolean moveRight() {
        if (canMoveRight()) {
            freeTetromino.moveRight();
            return true;
        }
        return false;
    }

    public boolean rotate() {
        if (canRotate()) {
            freeTetromino.rotate();
            return true;
        }
        return false;
    }

    /**
     * Checks for lines full of SquareTetrominos in the field and removes them.
     * @return the number of removed lines.
     */
    public int removeLines() {
        // TODO
        return 0;
    }

    /**
     * Checks if there is enough space in the field for a new Tetromino.
     * this method can be used to determine if the game is over (when there isn't enough space anymore)
     */
    private boolean canCreateNewFreeTetromino() {
        // TODO
        return false;
    }

    /**
     * Checks if current FreeTetromino can move Down.
     * There are two cases in which Tetromino can't move down:
     * 1. FreeTetromino reaches ground
     * 2. FreeTetromino is blocked by another sitting Tetromino
     */
    private boolean canMoveDown() {
        // TODO
        return false;
    }

    private boolean canMoveLeft() {
        // TODO
        return false;
    }

    private boolean canMoveRight() {
        // TODO
        return false;
    }

    private boolean canRotate() {
        // TODO
        return false;
    }
}
