package main.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class RestartPanel extends JPanel {
    public RestartPanel(ActionListener al) {
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        Font font = new Font("Ink Free", Font.BOLD, 20);

        JLabel label = new JLabel("Game Over!");
        label.setFont(font);
        label.setBorder(new EmptyBorder(20, 15, 30, 15));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(label);

        JButton button = new JButton("Replay");
        button.setFont(font);
        button.setBackground(Color.GRAY);
        button.setFocusable(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(al);
        this.add(button);
    }
}
