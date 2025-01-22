package org.zalaya.dataset.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CellTest {

    @Test
    public void shouldThrowExceptionWhenValueIsNull() {
        Object value = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new Cell(value);
        });
    }

    @Test
    public void shouldReturnCellValue() {
        Object value = "value";
        Cell cell = new Cell(value);

        assertEquals(value, cell.getValue());
    }

}
