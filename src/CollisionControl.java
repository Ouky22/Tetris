import field.Field;
import tetromino.FreeTetromino;
import tetromino.tetrominos.TTetromino;

public class CollisionControl {
    Field field;

    public CollisionControl(Field field) {
        this.field = field;
    }

    public boolean canCreateNewFreeTetromino() {
        // TODO
        return false;
    }

    public boolean canMoveDown(FreeTetromino freeTetromino) {
        // TODO erzeuge Kopie, führe darauf spezifische Operation aus, rufe "canMove()" auf
        return false;
    }

    public boolean canMoveLeft(FreeTetromino freeTetromino) {
        // TODO
        return false;
    }

    public boolean canMoveRight(FreeTetromino freeTetromino) {
        // TODO
        return false;
    }

    public boolean canRotate(FreeTetromino freeTetromino) {
        // TODO
        return false;
    }

    /**
     * returns true if current FreeTetromino can move.
     * There are two cases in which current FreeTetromino can't move:
     * 1. FreeTetromino's new position collides with wall of field
     * 1. FreeTetromino's new position collides with other sitting tetromino(s)
     */
    private boolean canMove(FreeTetromino currentTetromino, FreeTetromino futureTetromino) {
        // TODO Sequenzdiagramm oneNote (Nachbarkontrolle, FeldKontrolle)
        return false;
    }
}
