package test;

import main.CollisionControl;
import main.field.Field;
import main.tetromino.tetrominos.ITetromino;
import main.tetromino.tetrominos.OTetromino;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CollisionControlTest {
    Field field;
    CollisionControl collisionControl;

    @BeforeEach
    void init() {
        field = new Field(20, 20);
        collisionControl = new CollisionControl(field);
    }

    @Test
    void testCanAddTetrominoToField() {
        OTetromino tetromino = new OTetromino(field.getFieldWidth() / 2, 0);
        // no FieldPlace is taken so a new Tetromino can be added
        assertTrue(collisionControl.canAddTetrominoToField(tetromino));

        // add the tetromino
        field.fillField(tetromino.getTetrominoPositions(), tetromino.getColor());

        // now a new Tetromino can not be added, because the tetromino created before still blocks the start position
        assertFalse(collisionControl.canAddTetrominoToField(tetromino));
    }

    @Test
    void testCanMove() {
        // create new ITetromino in the middle of field where it can move in every direction and rotate
        ITetromino tetromino1 = new ITetromino(field.getFieldWidth() / 2, field.getFieldHeight() / 2);
        field.fillField(tetromino1.getTetrominoPositions(), tetromino1.getColor());
        assertAll(
                () -> assertTrue(collisionControl.canMoveDown(tetromino1), "should be able to move down"),
                () -> assertTrue(collisionControl.canMoveRight(tetromino1), "should be able to move right"),
                () -> assertTrue(collisionControl.canMoveLeft(tetromino1), "should be able to move left"),
                () -> assertTrue(collisionControl.canRotate(tetromino1), "should be able to rotate")
        );
    }

    @Test
    void testCanNotMove() {
        // create ITetromino in the bottom left corner where it can not move left, down and rotate
        ITetromino tetromino2 = new ITetromino(1, field.getFieldHeight() - 1);
        field.fillField(tetromino2.getTetrominoPositions(), tetromino2.getColor());
        assertAll(
                () -> assertFalse(collisionControl.canMoveDown(tetromino2), "should not be able to move down"),
                () -> assertFalse(collisionControl.canMoveLeft(tetromino2), "should not be able to move left"),
                () -> assertFalse(collisionControl.canRotate(tetromino2), "should not be able to rotate")
        );

        // create ITetromino in the bottom right corner where it can not move right
        ITetromino tetromino3 = new ITetromino(field.getFieldWidth() - 3, field.getFieldHeight() - 1);
        assertFalse(collisionControl.canMoveRight(tetromino3), "should not be able to move right");
    }

}
