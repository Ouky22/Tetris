package main.gui;

import main.GameManager;
import main.field.FieldPlace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainPanel extends JPanel implements ActionListener {
    private final int GRID_FIELD_WIDTH = 250;
    private final int GRID_FIELD_HEIGHT = 500;
    private final int SQUARE_SIDE_LENGTH = 25;
    private GameManager gameManager;

    InfoPanel infoPanel = new InfoPanel();

    public MainPanel() {
        int panelWidth = GRID_FIELD_WIDTH + (int) infoPanel.getPreferredSize().getWidth();
        this.setPreferredSize(new Dimension(panelWidth, GRID_FIELD_HEIGHT));
        this.setBackground(Color.DARK_GRAY);
        this.setFocusable(true);
        this.addKeyListener(new GameKeyAdapter());
        this.setLayout(null);

        infoPanel.setBounds(GRID_FIELD_WIDTH, 0, (int) infoPanel.getPreferredSize().getWidth(), GRID_FIELD_HEIGHT);
        this.add(infoPanel);

        infoPanel.updateCurrentScore(200);
        infoPanel.updateHighScore(2300);

        startGame();
    }

    private void startGame() {
        gameManager = new GameManager(GRID_FIELD_HEIGHT / SQUARE_SIDE_LENGTH,
                GRID_FIELD_WIDTH / SQUARE_SIDE_LENGTH, new Timer(GameManager.SPEED, this));
        gameManager.createNewFreeTetromino();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        drawSquares(g);
    }

    private void drawSquares(Graphics g) {
        FieldPlace[][] fieldPlaces = gameManager.getFieldPlaces();
        for (int i = 0; i < fieldPlaces.length; i++) {
            for (int k = 0; k < fieldPlaces[i].length; k++) {
                if (fieldPlaces[i][k].isTaken()) {
                    g.setColor(fieldPlaces[i][k].getColor());
                    g.fillRect(k * SQUARE_SIDE_LENGTH, i * SQUARE_SIDE_LENGTH,
                            SQUARE_SIDE_LENGTH, SQUARE_SIDE_LENGTH);
                }
            }
        }
    }

    private void drawGrid(Graphics g) {
        for (int i = 0; i < GRID_FIELD_WIDTH; i += SQUARE_SIDE_LENGTH) {
            g.drawLine(i, 0, i, GRID_FIELD_HEIGHT);
        }
        for (int i = 0; i < GRID_FIELD_HEIGHT; i += SQUARE_SIDE_LENGTH) {
            g.drawLine(0, i, GRID_FIELD_WIDTH, i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameManager.moveDown(false)) {
            gameManager.removeFullRows();

            if (!gameManager.createNewFreeTetromino()) {
                // TODO end game
            }
        }
        repaint();
    }

    class GameKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT, KeyEvent.VK_KP_LEFT -> gameManager.moveLeft();
                case KeyEvent.VK_RIGHT, KeyEvent.VK_KP_RIGHT -> gameManager.moveRight();
                case KeyEvent.VK_DOWN, KeyEvent.VK_KP_DOWN -> gameManager.moveDown(true);
                case KeyEvent.VK_UP, KeyEvent.VK_KP_UP -> gameManager.rotate();
            }
        }
    }
}
