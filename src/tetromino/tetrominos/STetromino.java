package tetromino.tetrominos;

import tetromino.FreeTetromino;
import tetromino.TetrominoColor;
import tetromino.TetrominoSquare;

public class STetromino extends FreeTetromino {
    public STetromino(int startXCoordinate, int startYCoordinate) {
        super(TetrominoColor.STETROMINO_COLOR, startXCoordinate, startYCoordinate);
    }

    @Override
    protected void createTetromino(int x, int y) {
        // add normal TetromioSquares (root is already added in constructor of FreeTetromino)
        tetrominoSquares[1] = new TetrominoSquare(x - 1, y);
        tetrominoSquares[2] = new TetrominoSquare(x, y - 1);
        tetrominoSquares[3] = new TetrominoSquare(x + 1, y - 1);
    }
}
