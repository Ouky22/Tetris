import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    static GameManager gameManager = new GameManager(20, 15);

    public static void main(String[] args) {

        gameManager.createNewFreeTetromino();
        while (true) {
            try {
                gameManager.drawField();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

            for(int i = 0; i < 1000; i++) {
                i++;
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            if(!gameManager.moveDown()) {
                if(!gameManager.createNewFreeTetromino())
                    break;
            }
        }
    }
}
