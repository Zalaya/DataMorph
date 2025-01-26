package org.zalaya.dataset.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InvalidDatasetExceptionTest {

    @Test
    void shouldThrowExceptionWhenInvoked() {
        assertThrows(InvalidDatasetException.class, () -> {
            throw new InvalidDatasetException("Invalid dataset exception");
        });
    }

}
