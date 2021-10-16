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

    /**
     * Sets the [color] of the fieldPlaces and [isTaken] to true
     * at the given coordinates
     */
    public void fillField(int[][] coordinates, String color) {
        for (int[] coordinate : coordinates) {
            int xCoordinate = coordinate[0];
            int yCoordinate = coordinate[1];
            fieldPlaces[xCoordinate][yCoordinate].setIsTaken(true);
            fieldPlaces[xCoordinate][yCoordinate].setColor(color);
        }
    }

    /**
     * Searches for one row where every place isTaken and "removes" it.
     * After each removal, taken places above slide down one step in the field.
     * Returns true if a full row is found and removed and false if there is
     * no full row.
     */
    public boolean removeFullRows() {
        for (int i = 0; i < fieldPlaces.length; i++) {
            // search for full rows
            boolean fullRowFound = true;
            for (FieldPlace place : fieldPlaces[i]) {
                if (!place.isTaken()) {
                    fullRowFound = false;
                    break;
                }
            }

            // "remove" full row of taken places and slide rows above
            // one step down to removed row
            if (fullRowFound) {
                // slide every row above row to be removed one step down (imagine the field)
                for (int k = i; k > 0; k--) {
                    // copy row above current row to current row
                    fieldPlaces[k] = fieldPlaces[k - 1];

                    // clear row above (needed because of the highest row)
                    Arrays.fill(fieldPlaces[k - 1], new FieldPlace());
                }
                return true;
            }
        }
        return false;
    }
}
