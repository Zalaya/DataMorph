package org.zalaya.dataset.models;

import org.junit.jupiter.api.Test;

import java.util.Map;

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
    public void shouldThrowExceptionWhenCellsAreEmpty() {
        Map<Header, Cell> cells = Map.of();

        assertThrows(IllegalArgumentException.class, () -> {
            new Row(cells);
        });
    }

}
