package org.zalaya.dataset.models;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" "})
    void shouldNotThrowExceptionWhenValueIsNullOrBlank(String value) {
        assertDoesNotThrow(() -> new Cell(value));
    }

}
