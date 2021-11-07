package gui;

import javax.swing.*;

public class MainFrame extends JFrame {
    final String MAIN_FRAME_TITLE = "Tetris";

    public MainFrame() {
        this.add(new MainPanel());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle(MAIN_FRAME_TITLE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null); // display frame in middle of screen
        this.setVisible(true);
    }
}
