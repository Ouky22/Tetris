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
    private final int PANEL_WIDTH = 500;
    private final int PANEL_HEIGHT = 500;
    private final int SQUARE_SIDE_LENGTH = 25;
    private GameManager gameManager;

    public MainPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.LIGHT_GRAY);
        this.setFocusable(true);
        this.addKeyListener(new GameKeyAdapter());
        startGame();
    }

    private void startGame() {
        gameManager = new GameManager(PANEL_HEIGHT / SQUARE_SIDE_LENGTH,
                PANEL_WIDTH / SQUARE_SIDE_LENGTH, new Timer(GameManager.SPEED, this));
        gameManager.createNewFreeTetromino();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (gameManager.isRepaintFieldRequired()) {
            drawGrid(g);
            drawAllSquares(g);
        } else {
            drawFreeTetromino(g);
        }
    }

    private void drawAllSquares(Graphics g) {
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

    private void drawFreeTetromino(Graphics g) {
        g.setColor(gameManager.getFreeTetrominoColor());
        for (int[] pos : gameManager.getFreeTetrominoCoordinates()) {
            g.fillRect(pos[0] * SQUARE_SIDE_LENGTH, pos[1] * SQUARE_SIDE_LENGTH,
                    SQUARE_SIDE_LENGTH, SQUARE_SIDE_LENGTH);
        }
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
        if (!gameManager.moveDown()) {
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
                case KeyEvent.VK_DOWN, KeyEvent.VK_KP_DOWN -> gameManager.moveDown();
                case KeyEvent.VK_UP, KeyEvent.VK_KP_UP -> gameManager.rotate();
            }
        }
    }
}
