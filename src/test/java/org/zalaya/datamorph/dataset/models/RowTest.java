package org.zalaya.datamorph.dataset.models;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import org.zalaya.datamorph.dataset.exceptions.InvalidRowException;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RowTest {

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowExceptionWhenCellsAreNullOrEmpty(LinkedHashMap<Header, Object> cells) {
        assertThrows(InvalidRowException.class, () -> {
            new Row(cells);
        });
    }

}
