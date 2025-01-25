package org.zalaya.dataset.models;

import org.junit.jupiter.api.Test;

import org.zalaya.dataset.enumerators.HeaderType;
import org.zalaya.dataset.exceptions.InvalidRowException;
import org.zalaya.dataset.exceptions.TypeMismatchException;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    void shouldThrowExceptionWhenCellsAreNull() {
        LinkedHashMap<Header, Cell> cells = null;

        assertThrows(InvalidRowException.class, () -> {
            new Row(cells);
        });
    }

    @Test
    void shouldThrowExceptionWhenCellValuesDoNotMatchExpectedType() {
        LinkedHashMap<Header, Cell> cells = new LinkedHashMap<>();
        Header header = new Header("header", HeaderType.STRING);
        Cell cell = new Cell(1);

        cells.put(header, cell);

        assertThrows(TypeMismatchException.class, () -> {
            new Row(cells);
        });
    }

    @Test
    void shouldReturnTrueWhenComparingRowsWithSameCells() {
        LinkedHashMap<Header, Cell> cells = new LinkedHashMap<>();
        Header header = new Header("header", HeaderType.STRING);
        Cell cell = new Cell("value");

        cells.put(header, cell);

        Row row1 = new Row(cells);
        Row row2 = new Row(cells);

        assertEquals(row1, row2);
    }

}
