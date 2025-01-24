package org.zalaya.dataset.builders;

import org.junit.jupiter.api.Test;

import org.zalaya.dataset.exceptions.InvalidRowException;
import org.zalaya.dataset.models.Header;
import org.zalaya.dataset.models.Row;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RowBuilderTest {

    @Test
    public void shouldThrowExceptionWhenCellsAreNull() {
        LinkedHashMap<Header, Object> cells = null;

        assertThrows(InvalidRowException.class, () -> {
            Row.builder()
                .cells(cells)
                .build();
        });
    }

}
