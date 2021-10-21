import field.Field;

public class CollisionControl {
    Field field;

    public CollisionControl(Field field) {
        this.field = field;
    }


    /**
     * returns true if there is enough space in the field for a new tetromino.
     * This method can be used to determine if the game is over
     * (when there isn't enough space anymore the game is over)
     */
    public boolean canCreateNewFreeTetromino() {
        // TODO
        return false;
    }

    /**
     * returns true if current FreeTetromino can move down.
     * There are two cases in which FreeTetromino can't move down:
     * 1. FreeTetromino reaches ground of field
     * 2. FreeTetromino is blocked by another sitting tetromino
     */
    public boolean canMoveDown() {
        // TODO
        return false;
    }

    /**
     * returns true if current FreeTetromino can move left.
     * There are two cases in which FreeTetromino can't move left:
     * 1. FreeTetromino reaches left boundary of field
     * 2. FreeTetromino is blocked by another sitting tetromino
     */
    public boolean canMoveLeft() {
        // TODO
        return false;
    }

    /**
     * same principle as method "canMoveLeft"
     */
    public boolean canMoveRight() {
        // TODO
        return false;
    }

    /**
     * returns true if current FreeTetromino can rotate.
     * There are two cases in which FreeTetromino can't rotate:
     * 1. FreeTetromino's new rotation position collides with wall of field
     * 1. FreeTetromino's new rotation position collides with other sitting tetromino
     */
    public boolean canRotate() {
        // TODO
        return false;
    }
}
