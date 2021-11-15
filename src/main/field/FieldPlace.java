package main.field;

import java.awt.*;

public class FieldPlace {
    private boolean taken = false;
    private Color color;

    public boolean isTaken() {
        return taken;
    }

    public void setIsTaken(boolean value) {
        taken = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color value) {
        color = value;
    }
}
