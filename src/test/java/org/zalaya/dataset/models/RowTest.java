package org.zalaya.dataset.models;

import org.junit.jupiter.api.Test;
import org.zalaya.dataset.enumerators.HeaderType;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RowTest {

    @Test
    public void shouldThrowExceptionWhenCellsAreNull() {
        Map<Header, Cell> cells = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new Row(cells);
        });
    }

    @Test
    public void shouldCreateEmptyRowWhenNoCellsAreProvided() {
        Row row = new Row();

        assertEquals(Map.of(), row.getCells());
    }

    @Test
    public void shouldCreateEmptyRowWhenEmptyCellsAreProvided() {
        Row row = new Row(Map.of());

        assertEquals(Map.of(), row.getCells());
    }

    @Test
    public void shouldThrowExceptionWhenAddingNullHeader() {
        Row row = new Row();
        Header header = null;
        Cell cell = new Cell("cell");

        assertThrows(IllegalArgumentException.class, () -> {
            row.addCell(header, cell);
        });
    }

    @Test
    public void shouldThrowExceptionWhenAddingNullCell() {
        Row row = new Row();
        Header header = new Header("header", HeaderType.STRING);
        Cell cell = null;

        assertThrows(IllegalArgumentException.class, () -> {
            row.addCell(header, cell);
        });
    }

    @Test
    public void shouldReturnRowCells() {
        Header header = new Header("header", HeaderType.STRING);
        Cell cell = new Cell("cell");
        Row row = new Row(Map.of(header, cell));

        assertEquals(Map.of(header, cell), row.getCells());
    }

}
