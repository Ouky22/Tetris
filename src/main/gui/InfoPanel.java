package main.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InfoPanel extends JPanel {
    private final JLabel currentScoreLabel = new JLabel("Your Score");
    private final JLabel highScoreLabel = new JLabel("High Score");

    public InfoPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.LIGHT_GRAY);

        Font scoreLabelFont = new Font("Ink Free", Font.BOLD, 20);

        highScoreLabel.setFont(scoreLabelFont);
        highScoreLabel.setBorder(new EmptyBorder(15, 15, 50, 10));
        this.add(highScoreLabel);

        currentScoreLabel.setFont(scoreLabelFont);
        currentScoreLabel.setBorder(new EmptyBorder(0, 15, 0, 10));
        currentScoreLabel.setPreferredSize(new Dimension(125, scoreLabelFont.getSize()));
        this.add(currentScoreLabel);
    }

    public void updateCurrentScore(int score) {
        currentScoreLabel.setText("<html><center>Your Score:<br>" + score + "</center></html>");
    }

    public void updateHighScore(int score) {
        highScoreLabel.setText("<html><center>High Score:<br>" + score + "</center></html>");
    }
}
