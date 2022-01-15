package test.field;

import main.field.Field;
import main.field.FieldPlace;
import org.junit.jupiter.api.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {
    Field field;
    int fieldHeight = 25;
    int fieldWidth = 20;
    int[][] testCoordinates = {{0, 0}, {0, fieldHeight - 1}, {fieldWidth - 1, 0}, {fieldWidth - 1, fieldHeight - 1}};

    @BeforeEach
    void init() {
        field = new Field(fieldHeight, fieldWidth);
    }

    @Test
    void testFillField() {
        fillFieldWithTestCoordinates();
        for (int[] coordinate : testCoordinates) {
            int x = coordinate[0];
            int y = coordinate[1];
            assertTrue(field.getFieldPlaces()[y][x].isTaken());
        }
    }

    @Test
    void testClearFieldPlaces() {
        fillFieldWithTestCoordinates();
        field.clearFieldPlaces(testCoordinates);
        for (int[] coordinate : testCoordinates) {
            int x = coordinate[0];
            int y = coordinate[1];
            assertFalse(field.getFieldPlaces()[y][x].isTaken());
        }
    }

    @Test
    void testRemoveFullRow() {
        // at the beginning there is no full row
        assertFalse(field.removeFullRow());

        // now set every FieldPlace to taken
        field.fillField(getAllFieldCoordinates(), Color.WHITE);

        // Because every FieldPlace in the field is taken, the amount of full rows is equal to the fieldHeight.
        // Now remove every full row.
        for (int i = 0; i < fieldHeight; i++)
            assertTrue(field.removeFullRow());

        // Now there should be no full rows
        assertFalse(field.removeFullRow());

        // and no FieldPlace in the field is taken
        for (FieldPlace[] fieldPlacesRow : field.getFieldPlaces())
            for (FieldPlace field : fieldPlacesRow)
                assertFalse(field.isTaken());
    }

    @Nested
    @DisplayName("get methods")
    class GetTest {
        @Test
        void testGetFieldHeight() {
            assertEquals(fieldHeight, field.getFieldHeight(), "should return field height");
        }

        @Test
        void testGetFieldWidth() {
            assertEquals(fieldWidth, field.getFieldWidth(), "should return field width");
        }

        @Test
        void testGetFieldPlaces() {
            FieldPlace[][] fieldPlaces = field.getFieldPlaces();
            assertEquals(fieldHeight, fieldPlaces.length);
            assertEquals(fieldWidth, fieldPlaces[0].length);
        }
    }

    private void fillFieldWithTestCoordinates() {
        field.fillField(testCoordinates, Color.WHITE);
    }

    /**
     * returns all possible 2D-coordinates in the current field
     */
    private int[][] getAllFieldCoordinates() {
        int[][] fieldCoordinates = new int[fieldHeight * fieldWidth][2];
        for (int y = 0; y < fieldHeight; y++) {
            for (int x = 0; x < fieldWidth; x++) {
                fieldCoordinates[y * fieldWidth + x] = new int[]{x, y};
            }
        }
        return fieldCoordinates;
    }
}