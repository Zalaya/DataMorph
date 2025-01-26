package org.zalaya.dataset.models;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @ParameterizedTest
    @NullAndEmptySource
    void shouldNotThrowExceptionForNullOrEmptyValue(String value) {
        assertDoesNotThrow(() -> new Cell(value));
    }

}
