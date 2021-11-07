package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {
    private final int PANEL_WIDTH = 500;
    private final int PANEL_HEIGHT = 500;
    private final int SQUARE_SIDE_LENGTH = 25;
    private final int SPEED = 100; // delay

    public MainPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.LIGHT_GRAY);
        this.setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
    }

    private void drawGrid(Graphics g) {
        for (int i = 0; i < PANEL_WIDTH; i += SQUARE_SIDE_LENGTH) {
            g.drawLine(i, 0, i, PANEL_HEIGHT);
        }
        for (int i = 0; i < PANEL_HEIGHT; i += SQUARE_SIDE_LENGTH) {
            g.drawLine(0, i, PANEL_WIDTH, i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
