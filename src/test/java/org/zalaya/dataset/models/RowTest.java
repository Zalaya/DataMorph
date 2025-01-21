package org.zalaya.dataset.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RowTest {

    @Test
    public void shouldThrowExceptionWhenCellsAreNull() {
        List<Cell> cells = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new Row(cells);
        });
    }

    @Test
    public void shouldThrowExceptionWhenCellsAreEmpty() {
        List<Cell> cells = List.of();

        assertThrows(IllegalArgumentException.class, () -> {
            new Row(cells);
        });
    }

    @Test
    public void shouldReturnCells() {
        List<Cell> cells = List.of(new Cell("value"));
        Row row = new Row(cells);

        assertEquals(cells, row.getCells());
    }

}
