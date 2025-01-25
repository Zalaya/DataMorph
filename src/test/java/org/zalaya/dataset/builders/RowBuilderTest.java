package org.zalaya.dataset.builders;

import org.junit.jupiter.api.Test;

import org.zalaya.dataset.exceptions.InvalidRowException;
import org.zalaya.dataset.models.Cell;
import org.zalaya.dataset.models.Header;
import org.zalaya.dataset.models.Row;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RowBuilderTest {

    // TODO: Implement the tests for the Cell class and validations

    @Test
    void shouldThrowExceptionWhenCellsAreNull() {
        Map<Header, Cell> cells = null;
        RowBuilder builder = Row.builder();
        builder.cells(cells);

        assertThrows(InvalidRowException.class, builder::build);
    }

}
