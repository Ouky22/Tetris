package field;

public class FieldPlace {
    private boolean taken = false;
    private String color;

    public boolean isTaken() {
        return taken;
    }

    public void setIsTaken(boolean value) {
        taken = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String value) {
        color = value;
    }
}
