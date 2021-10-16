package field;

import java.util.Arrays;

public class Field {
    FieldPlace[][] fieldPlaces;
    int height;
    int width;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Field(int height, int width) {
        this.height = height;
        this.width = width;

        fieldPlaces = new FieldPlace[height][width];

        // fill field with instances of FieldPlace
        for (FieldPlace[] row : fieldPlaces) {
            Arrays.fill(row, new FieldPlace());
        }
    }
}
