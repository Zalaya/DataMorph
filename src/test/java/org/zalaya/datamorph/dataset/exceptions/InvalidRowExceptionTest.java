package org.zalaya.datamorph.dataset.exceptions;

import org.junit.jupiter.api.Test;
import org.zalaya.datamorph.dataset.exceptions.InvalidRowException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InvalidRowExceptionTest {

    @Test
    void shouldThrowExceptionWhenInvoked() {
        assertThrows(InvalidRowException.class, () -> {
            throw new InvalidRowException("Invalid row exception");
        });
    }

}
