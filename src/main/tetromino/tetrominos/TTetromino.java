package main.tetromino.tetrominos;

import main.tetromino.FreeTetromino;
import main.tetromino.TetrominoColor;
import main.tetromino.TetrominoSquare;

public class TTetromino extends FreeTetromino {

    public TTetromino(int startXCoordinate, int startYCoordinate) {
        super(TetrominoColor.TTETROMINO_COLOR, startXCoordinate, startYCoordinate);
    }

    @Override
    protected void createTetromino(int x, int y) {
        // add normal TetrominoSquares (root is already added in constructor of FreeTetromino)
        tetrominoSquares[1] = new TetrominoSquare(x - 1, y);
        tetrominoSquares[2] = new TetrominoSquare(x, y + 1);
        tetrominoSquares[3] = new TetrominoSquare(x + 1, y);
    }
}
