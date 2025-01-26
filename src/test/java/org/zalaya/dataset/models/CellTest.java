package org.zalaya.dataset.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @ParameterizedTest
    @NullAndEmptySource
    void shouldInstantiateWithNullOrEmptyValue(String value) {
        assertDoesNotThrow(() -> new Cell(value));
    }

    @Test
    void shouldReturnTrueWhenComparingTwoCellsWithSameValue() {
        String value = "value";
        Cell cell1 = new Cell(value);
        Cell cell2 = new Cell(value);

        assertEquals(cell1, cell2);
    }

    @Test
    void shouldReturnFalseWhenComparingTwoCellsWithDifferentValue() {
        String value1 = "value1";
        String value2 = "value2";
        Cell cell1 = new Cell(value1);
        Cell cell2 = new Cell(value2);

        assertNotEquals(cell1, cell2);
    }

}
