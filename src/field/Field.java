package field;

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

    /**
     * Searches for one row where every place isTaken and "removes" it.
     * After each removal, taken places above slide down one step in the field.
     * Returns true if a full row is found and removed and false if there is
     * no full row.
     */
    public boolean removeFullRow() {
        for (int i = 0; i < fieldHeight; i++) {
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
                for (int k = i; k < fieldHeight - 1; k++) {
                    // copy row above current row to current row
                    fieldPlaces[k] = fieldPlaces[k + 1];
                }
                // clear highest row
                for (int k = 0; k < fieldWidth; k++) {
                    fieldPlaces[fieldHeight - 1][k] = new FieldPlace();
                }
                return true;
            }
        }
        return false;
    }
}
