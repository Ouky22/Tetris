package tetromino;

abstract public class FreeTetromino {
    protected String color;

    protected TetrominoSquare[] tetrominoSquares = new TetrominoSquare[4];

    public FreeTetromino(String color, int startXCoordinate, int startYCoordinate) {
        this.color = color;
        // add root TetrominoSquare
        tetrominoSquares[0] = new TetrominoSquare(startXCoordinate, startYCoordinate, true);
        createTetromino(startXCoordinate, startYCoordinate);
    }

    public int[][] getTetrominoPositions() {
        int[][] positions = new int[4][2];
        for (int i = 0; i < tetrominoSquares.length; i++) {
            positions[i] = tetrominoSquares[i].getCoordinates();
        }
        return positions;
    }

    public int[] getRootTetrominoPosition() {
        for (TetrominoSquare tetrominoSquare : tetrominoSquares) {
            if (tetrominoSquare.isRoot())
                return tetrominoSquare.getCoordinates();
        }
        return null;
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

    /**
     * this method rotates every non-root tetrominoSquare of an free tetromino
     * 90 degrees around the root tetrominoSquare
     */
    public void rotate() {
        int[] rootTetroCoordinates = getRootTetrominoPosition();

        for (int i = 1; i < tetrominoSquares.length; i++) {
            int[] tetroSquareCoordinates = tetrominoSquares[i].getCoordinates();

            // create help vector between coordinates of rootSquare and coordinates of square to be rotated
            int[] helpVector = new int[]{
                    tetroSquareCoordinates[0] - rootTetroCoordinates[0],
                    tetroSquareCoordinates[1] - rootTetroCoordinates[1],
            };

            // rotate help vector around origin of coordinates
            int[] rotatedHelpVector = new int[]{
                    (int) (Math.cos(Math.toRadians(90)) * helpVector[0])
                            + (int) (-1 * Math.sin(Math.toRadians(90)) * helpVector[1]),
                    (int) (Math.sin(Math.toRadians(90)) * helpVector[0])
                            + (int) (Math.cos(Math.toRadians(90)) * helpVector[1])
            };

            // add rotated help vector to coordinates of root vector to get new coordinates of rotated Square
            int[] rotatedSquareCoordinates = new int[]{
                    rootTetroCoordinates[0] + rotatedHelpVector[0],
                    rootTetroCoordinates[1] + rotatedHelpVector[1]
            };

            tetrominoSquares[i].setCoordinates(rotatedSquareCoordinates[0], rotatedSquareCoordinates[1]);
        }
    }

    /**
     * in createTetromino every FreeTetromino needs to create their specific coordinates
     * according to their pattern in the start position
     */
    protected abstract void createTetromino(int startXCoordinate, int startYCoordinate);
}