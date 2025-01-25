package org.zalaya.dataset.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { " ", "  ", "\t", "\n" })
    void shouldNotThrowExceptionWhenValueIsNullOrBlank(String value) {
        assertDoesNotThrow(() -> new Cell(value));
    }

    @Test
    void shouldReturnTrueWhenComparingCellsWithSameValues() {
        Cell cell1 = new Cell(1);
        Cell cell2 = new Cell(1);

        assertEquals(cell1, cell2);
    }

    @Test
    void shouldReturnFalseWhenComparingCellsWithDifferentValues() {
        Cell cell1 = new Cell(1);
        Cell cell2 = new Cell(2);

        assertNotEquals(cell1, cell2);
    }

}
