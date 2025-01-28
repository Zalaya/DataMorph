package org.zalaya.datamorph.dataset.exceptions;

import org.junit.jupiter.api.Test;
import org.zalaya.datamorph.dataset.exceptions.InvalidDatasetException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InvalidDatasetExceptionTest {

    @Test
    void shouldThrowExceptionWhenInvoked() {
        assertThrows(InvalidDatasetException.class, () -> {
            throw new InvalidDatasetException("Invalid dataset exception");
        });
    }

}
