package org.zalaya.dataset;

import org.junit.jupiter.api.Test;
import org.zalaya.dataset.models.Cell;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CellTest {

    @Test
    public void shouldCreateCellWithValue() {
        Object value = new Object();

        assertDoesNotThrow(() -> {
            new Cell(value);
        });
    }

    @Test
    public void shouldCreateCellWithNullValue() {
        Object value = null;

        assertDoesNotThrow(() -> {
            new Cell(value);
        });
    }

    @Test
    public void shouldCreateCellWithEmptyValue() {
        Object value = "";

        assertDoesNotThrow(() -> {
            new Cell(value);
        });
    }

    @Test
    public void shouldCreateCellWithBlankValue() {
        Object value = " ";

        assertDoesNotThrow(() -> {
            new Cell(value);
        });
    }

}
