package tetromino.tetrominos;

import tetromino.FreeTetromino;
import tetromino.TetrominoSquare;

public class TTetromino extends FreeTetromino {

    public TTetromino(String color, int startXCoordinate, int startYCoordinate) {
        super(color, startXCoordinate, startYCoordinate);
    }

    @Override
    protected void createTetromino(int x, int y) {
        // add normal TetrominoSquares (root is already added in constructor of FreeTetromino)
        tetrominoSquares[1] = new TetrominoSquare(x - 1, y);
        tetrominoSquares[2] = new TetrominoSquare(x, y + 1);
        tetrominoSquares[3] = new TetrominoSquare(x + 1, y);
    }

    @Override
    protected void setNoRotationCoordinates() {
        TetrominoSquare rootTetrominoSquare = getRootTetrominoSquare();
        int x = rootTetrominoSquare.getXCoordinate();
        int y = rootTetrominoSquare.getYCoordinate();

        tetrominoSquares[1].setCoordinates(x - 1, y);
        tetrominoSquares[2].setCoordinates(x, y + 1);
        tetrominoSquares[3].setCoordinates(x + 1, y);
    }

    @Override
    protected void setOneQuarterRotationCoordinates() {
        TetrominoSquare rootTetrominoSquare = getRootTetrominoSquare();
        int x = rootTetrominoSquare.getXCoordinate();
        int y = rootTetrominoSquare.getYCoordinate();

        tetrominoSquares[1].setCoordinates(x, y + 1);
        tetrominoSquares[2].setCoordinates(x + 1, y);
        tetrominoSquares[3].setCoordinates(x, y - 1);
    }

    @Override
    protected void setHalfRotationCoordinates() {
        TetrominoSquare rootTetrominoSquare = getRootTetrominoSquare();
        int x = rootTetrominoSquare.getXCoordinate();
        int y = rootTetrominoSquare.getYCoordinate();

        tetrominoSquares[1].setCoordinates(x + 1, y);
        tetrominoSquares[2].setCoordinates(x, y - 1);
        tetrominoSquares[3].setCoordinates(x - 1, y);
    }

    @Override
    protected void setThreeQuarterRotationCoordinates() {
        TetrominoSquare rootTetrominoSquare = getRootTetrominoSquare();
        int x = rootTetrominoSquare.getXCoordinate();
        int y = rootTetrominoSquare.getYCoordinate();

        tetrominoSquares[1].setCoordinates(x, y - 1);
        tetrominoSquares[2].setCoordinates(x - 1, y);
        tetrominoSquares[3].setCoordinates(x, y + 1);
    }
}
