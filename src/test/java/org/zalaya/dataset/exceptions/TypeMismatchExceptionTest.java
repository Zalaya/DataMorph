package org.zalaya.dataset.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TypeMismatchExceptionTest {

    @Test
    void shouldThrowExceptionWhenInvoked() {
        assertThrows(TypeMismatchException.class, () -> {
            throw new TypeMismatchException("Type mismatch exception");
        });
    }

}
