package Tetromino;

public class TTetromino extends FreeTetromino{

    public TTetromino(String color, int startXCoordinate, int startYCoordinate){
        super(color, startXCoordinate, startYCoordinate);
    }

    @Override
    protected void createTetromino(int x, int y) {
        // add root TetrominoSquare
        tetrominoSquares[0] = new TetrominoSquare(x, y, true);

        // add normal TetrominoSquares
        tetrominoSquares[1] = new TetrominoSquare(x - 1, y);
        tetrominoSquares[2] = new TetrominoSquare(x, y + 1);
        tetrominoSquares[3] = new TetrominoSquare(x + 1, y);
    }

    @Override
    public void rotate() {

    }
}
