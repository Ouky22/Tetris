import tetromino.FreeTetromino;
import tetromino.tetrominos.TTetromino;

public class Main {
    public static void main(String[] args) {
        TTetromino tetro = new TTetromino(5, 2);

        for (int i = 0; i < 4; i++) {
            int[][] positions = tetro.getTetrominoPositions();
            System.out.printf("%n%n%d.:%n", i);
            for (int k = 0; k < positions.length; k++) {
                System.out.printf("%s: x:%d     y:%d%n", (k == 0) ? "root" : "   " + k, positions[k][0], positions[k][1]);
            }
            tetro.rotate();
        }
    }
}
