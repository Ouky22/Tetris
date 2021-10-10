package tetromino;

abstract public class FreeTetromino {
    protected String color;

    protected RotationPosition currentRotationPosition = RotationPosition.noRotation;

    protected enum RotationPosition {
        noRotation, oneQuarterRotation, halfRotation, threeQuarterRotation;

        public RotationPosition getNext() {
            return this.ordinal() < RotationPosition.values().length - 1
                    ? RotationPosition.values()[this.ordinal() + 1]
                    : RotationPosition.values()[0];
        }
    }

    protected TetrominoSquare[] tetrominoSquares = new TetrominoSquare[4];

    public FreeTetromino(String color, int startXCoordinate, int startYCoordinate) {
        this.color = color;
        createTetromino(startXCoordinate, startYCoordinate);
    }

    public int[][] getTetrominoPositions() {
        int[][] positions = new int[4][2];
        for (int i = 0; i < tetrominoSquares.length; i++) {
            positions[i][0] = tetrominoSquares[i].getXCoordinate();
            positions[i][1] = tetrominoSquares[i].getYCoordinate();
        }
        return positions;
    }

    public int[] getRootTetrominoPosition() {
        for (TetrominoSquare tetrominoSquare : tetrominoSquares) {
            if (tetrominoSquare.isRoot())
                return new int[]{tetrominoSquare.getXCoordinate(), tetrominoSquare.getYCoordinate()};
        }
        return new int[0];
    }

    public void moveDown() {
        for (TetrominoSquare tetroSquare : tetrominoSquares) {
            tetroSquare.incrementY();
        }
    }

    public void moveRight() {
        for (TetrominoSquare tetroSquare : tetrominoSquares) {
            tetroSquare.incrementX();
        }
    }

    public void moveLeft() {
        for (TetrominoSquare tetroSquare : tetrominoSquares) {
            tetroSquare.decrementX();
        }
    }

    public void rotate() {
        currentRotationPosition = currentRotationPosition.getNext();

        switch (currentRotationPosition) {
            case noRotation -> setNoRotationCoordinates();
            case oneQuarterRotation -> setOneQuarterRotationCoordinates();
            case halfRotation -> setHalfRotationCoordinates();
            case threeQuarterRotation -> setThreeQuarterRotationCoordinates();
        }
    }

    protected abstract void setNoRotationCoordinates();

    protected abstract void setOneQuarterRotationCoordinates();

    protected abstract void setHalfRotationCoordinates();

    protected abstract void setThreeQuarterRotationCoordinates();

    protected abstract void createTetromino(int startXCoordinate, int startYCoordinate);
}
