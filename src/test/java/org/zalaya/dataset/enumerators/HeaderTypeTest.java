package org.zalaya.dataset.enumerators;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeaderTypeTest {

    @Test
    void shouldReturnNumberClassWhenInvokingNumberType() {
        // Arrange
        HeaderType headerType = HeaderType.NUMBER;

        // Act
        Class<?> type = headerType.getType();

        // Assert
        assertEquals(Number.class, type);
    }

    @Test
    void shouldReturnStringClassWhenInvokingStringType() {
        // Arrange
        HeaderType headerType = HeaderType.STRING;

        // Act
        Class<?> type = headerType.getType();

        // Assert
        assertEquals(String.class, type);
    }

    @Test
    void shouldReturnLocalDateClassWhenInvokingDateType() {
        // Arrange
        HeaderType headerType = HeaderType.DATE;

        // Act
        Class<?> type = headerType.getType();

        // Assert
        assertEquals(LocalDate.class, type);
    }

}
