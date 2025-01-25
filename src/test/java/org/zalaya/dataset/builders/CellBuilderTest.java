package org.zalaya.dataset.builders;

import org.junit.jupiter.api.Test;
import org.zalaya.dataset.exceptions.InvalidCellException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CellBuilderTest {

    @Test
    void shouldThrowExceptionWhenValueIsNull() {
        Object value = null;
        CellBuilder builder = new CellBuilder();
        builder.value(value);

        assertThrows(InvalidCellException.class, builder::build);
    }

}
