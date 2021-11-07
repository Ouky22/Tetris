package field;

/**
 * represents the game field by a 2D array containing objects of
 * type [FieldPlace].
 * For usage in a gui the field has to be scaled to the right size
 * (multiply each coordinate by square side length)
 */
public class Field {
    FieldPlace[][] fieldPlaces;
    int fieldHeight;
    int fieldWidth;

    public int getFieldHeight() {
        return fieldHeight;
    }

    public int getFieldWidth() {
        return fieldWidth;
    }

    public FieldPlace[][] getFieldPlaces() {
        return fieldPlaces;
    }

    public Field(int fieldHeight, int fieldWidth) {
        this.fieldHeight = fieldHeight;
        this.fieldWidth = fieldWidth;

        fieldPlaces = new FieldPlace[fieldHeight][fieldWidth];

        // fill field with instances of FieldPlace
        for (int i = 0; i < fieldPlaces.length; i++) {
            for (int k = 0; k < fieldPlaces[i].length; k++) {
                fieldPlaces[i][k] = new FieldPlace();
            }
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
            fieldPlaces[yCoordinate][xCoordinate].setIsTaken(true);
            fieldPlaces[yCoordinate][xCoordinate].setColor(color);
        }
    }

    public void clearFieldPlaces(int[][] coordinates) {
        for (int[] coordinate : coordinates) {
            int xCoordinate = coordinate[0];
            int yCoordinate = coordinate[1];
            fieldPlaces[yCoordinate][xCoordinate].setIsTaken(false);
            fieldPlaces[yCoordinate][xCoordinate].setColor(null);
        }
    }

    /**
     * Searches for one row where every place isTaken and "removes" it.
     * To remove the full row, every row above full row will be copied
     * one step down towards the full row and the highest row will be cleared.
     * Returns true if a full row is found and removed and false if there is
     * no full row.
     */
    public boolean removeFullRow() {
        for (int i = fieldHeight - 1; i > 0; i--) {
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
                // slide every row above row to be removed one step down
                for (int k = i; k > 0; k--) {
                    // copy row above current row to current row
                    fieldPlaces[k] = fieldPlaces[k - 1];
                }

                // clear highest row, because if full row is found
                // and removed, the highest row must always be cleared
                for (int k = 0; k < fieldWidth; k++) {
                    fieldPlaces[0][k] = new FieldPlace();
                }
                return true;
            }
        }
        return false;
    }
}
