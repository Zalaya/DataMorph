package org.zalaya.dataset.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InvalidHeaderExceptionTest {

    @Test
    void shouldThrowExceptionWhenInvoked() {
        assertThrows(InvalidHeaderException.class, () -> {
            throw new InvalidHeaderException("Invalid header exception");
        });
    }

}
