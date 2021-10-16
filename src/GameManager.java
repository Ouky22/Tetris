import jdk.jshell.spi.ExecutionControl;
import tetromino.FreeTetromino;
import tetromino.tetrominos.ITetromino;

public class GameManager {
    private FreeTetromino freeTetromino;

    public boolean createNewFreeTetromino(){
        int startXCoordinate = 0;
        int startYCoordinate = 0;

        if(!canCreateNewFreeTetromino())
            return false;

        // TODO
        switch((int)(Math.random() * 7)){
            case 0:

                return true;
            case 1:

                return true;
            case 2:

                return true;
            case 3:

                return true;
            case 4:

                return true;
            case 5:

                return true;
            case 6:

                return true;
            default:
                return true;
        }
    }

    public boolean moveDown() {
        if (canMoveDown()) {
            freeTetromino.moveDown();
            return true;
        } else {
            return false;
        }
    }

    private boolean canMoveDown() {
        // TODO
        return false;
    }

    private boolean canCreateNewFreeTetromino(){
        // TODO
        return false;
    }
}
