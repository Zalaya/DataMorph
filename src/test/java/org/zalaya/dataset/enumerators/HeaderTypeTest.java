package org.zalaya.dataset.enumerators;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeaderTypeTest {

    @Test
    void shouldReturnNumberType() {
        HeaderType headerType = HeaderType.NUMBER;
        Class<?> actualType = headerType.getType();

        assertEquals(Number.class, actualType);
    }

    @Test
    void shouldReturnStringType() {
        HeaderType headerType = HeaderType.STRING;
        Class<?> actualType = headerType.getType();

        assertEquals(String.class, actualType);
    }

    @Test
    void shouldReturnDateType() {
        HeaderType headerType = HeaderType.DATE;
        Class<?> actualType = headerType.getType();

        assertEquals(LocalDate.class, actualType);
    }

}
