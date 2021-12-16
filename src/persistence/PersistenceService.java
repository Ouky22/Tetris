package persistence;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PersistenceService {
    private final String HIGH_SCORE_FILE_NAME = "highScore.txt";

    public void saveHighScore(int highScore) {
        try (FileWriter fileWriter = new FileWriter(HIGH_SCORE_FILE_NAME)) {
            fileWriter.write(String.valueOf(highScore));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int readHighScore() {
        int highScore = 0;
        try (Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "\\" + HIGH_SCORE_FILE_NAME))) {
            while (sc.hasNextLine())
                highScore = Integer.parseInt(sc.nextLine());
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NumberFormatException ex) { // highScore file contains invalid data
            clearHighScoreFile();
        }
        return highScore;
    }

    private void clearHighScoreFile() {
        try (FileWriter fileWriter = new FileWriter(HIGH_SCORE_FILE_NAME)) {
            fileWriter.write("");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
