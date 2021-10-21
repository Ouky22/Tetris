import jdk.jshell.spi.ExecutionControl;
import tetromino.FreeTetromino;
import tetromino.tetrominos.*;

public class GameManager {
    private FreeTetromino freeTetromino;
    private CollisionControl collisionControl;

    public boolean createNewFreeTetromino() {
        int startXCoordinate = 0;
        int startYCoordinate = 0;

        if (!collisionControl.canCreateNewFreeTetromino())
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
        if (collisionControl.canMoveDown(freeTetromino)) {
            freeTetromino.moveDown();
            return true;
        }
        return false;
    }

    public boolean moveLeft() {
        if (collisionControl.canMoveLeft(freeTetromino)) {
            freeTetromino.moveLeft();
            return true;
        }
        return false;
    }

    public boolean moveRight() {
        if (collisionControl.canMoveRight(freeTetromino)) {
            freeTetromino.moveRight();
            return true;
        }
        return false;
    }

    public boolean rotate() {
        if (collisionControl.canRotate(freeTetromino)) {
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
}
