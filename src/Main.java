import field.Field;
import tetromino.FreeTetromino;
import tetromino.tetrominos.TTetromino;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TTetromino tetro = new TTetromino(3, 9);


        Field field = new Field(10, 5);
        int[][] coordinates = new int[20][2];
        int yCounter = 0;
        int xCounter = 0;
        for(int i = 0; i < 20; i++){
            coordinates[i] = new int[]{xCounter, yCounter};
            xCounter++;
            if(xCounter > 4){
                yCounter++;
                xCounter = 0;
            }
        }

        field.fillField(coordinates, "black");
        boolean foundRow = field.removeFullRow();
        System.out.println("bla");

        CollisionControl cc = new CollisionControl(field);
        cc.canMoveDown(tetro);


//        for (int i = 0; i < 4; i++) {
//            int[][] positions = tetro.getTetrominoPositions();
//            System.out.printf("%n%n%d.:%n", i);
//            for (int k = 0; k < positions.length; k++) {
//                System.out.printf("%s: x:%d     y:%d%n", (k == 0) ? "root" : "   " + k, positions[k][0], positions[k][1]);
//            }
//            tetro.rotate();
//        }
    }
}
