package org.zalaya.dataset.models;

import org.junit.jupiter.api.Test;

import org.zalaya.dataset.enumerators.HeaderType;
import org.zalaya.dataset.exceptions.InvalidRowException;
import org.zalaya.dataset.exceptions.TypeMismatchException;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

public class RowTest {

    @Test
    public void shouldThrowExceptionWhenCellsAreNull() {
        LinkedHashMap<Header, Object> cells = null;

        assertThrows(InvalidRowException.class, () -> {
            new Row(cells);
        });
    }

    @Test
    public void shouldThrowExceptionWhenCellValuesDoNotMatchExpectedType() {
        LinkedHashMap<Header, Object> cells = new LinkedHashMap<>();
        Header header = new Header("header", HeaderType.STRING);

        cells.put(header, 1);

        assertThrows(TypeMismatchException.class, () -> {
            new Row(cells);
        });
    }

    @Test
    public void shouldReturnTrueWhenComparingRowsWithSameCells() {
        LinkedHashMap<Header, Object> cells = new LinkedHashMap<>();
        Header header = new Header("header", HeaderType.STRING);

        cells.put(header, "value");

        Row row1 = new Row(cells);
        Row row2 = new Row(cells);

        assertEquals(row1, row2);
    }

}
