package org.zalaya.dataset.builders;

import org.junit.jupiter.api.Test;

import org.zalaya.dataset.exceptions.InvalidRowException;
import org.zalaya.dataset.models.Header;
import org.zalaya.dataset.models.Row;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RowBuilderTest {

    @Test
    void shouldThrowExceptionWhenCellsAreNull() {
        Map<Header, Object> cells = null;
        RowBuilder builder = Row.builder();
        builder.cells(cells);

        assertThrows(InvalidRowException.class, builder::build);
    }

}
