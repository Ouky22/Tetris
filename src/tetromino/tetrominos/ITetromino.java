package tetromino.tetrominos;

import tetromino.FreeTetromino;
import tetromino.TetrominoColor;
import tetromino.TetrominoSquare;

public class ITetromino extends FreeTetromino {

    public ITetromino(int startXCoordinate, int startYCoordinate) {
        super(TetrominoColor.ITETROMINO_COLOR, startXCoordinate, startYCoordinate);
    }

    @Override
    protected void createTetromino(int x, int y) {
        // add normal TetrominoSquares (root is already added in constructor of FreeTetromino)
        tetrominoSquares[1] = new TetrominoSquare(x - 1, y);
        tetrominoSquares[2] = new TetrominoSquare(x + 1, y);
        tetrominoSquares[3] = new TetrominoSquare(x + 2, y);
    }
}
