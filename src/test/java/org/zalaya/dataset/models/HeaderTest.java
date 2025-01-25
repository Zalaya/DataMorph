package org.zalaya.dataset.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.zalaya.dataset.enumerators.HeaderType;
import org.zalaya.dataset.exceptions.InvalidHeaderException;

import static org.junit.jupiter.api.Assertions.*;

class HeaderTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { " " })
    void shouldThrowExceptionWhenNameIsNullOrBlank(String name) {
        assertThrows(InvalidHeaderException.class, () -> {
            new Header(name, HeaderType.STRING);
        });
    }

    @Test
    void shouldThrowExceptionWhenTypeIsNull() {
        HeaderType type = null;

        assertThrows(InvalidHeaderException.class, () -> {
            new Header("header", type);
        });
    }

    @Test
    void shouldReturnTrueWhenComparingHeadersWithSameName() {
        Header header1 = new Header("header", HeaderType.STRING);
        Header header2 = new Header("header", HeaderType.STRING);

        assertEquals(header1, header2);
    }

    @Test
    void shouldReturnFalseWhenComparingHeadersWithDifferentName() {
        Header header1 = new Header("header1", HeaderType.STRING);
        Header header2 = new Header("header2", HeaderType.STRING);

        assertNotEquals(header1, header2);
    }

}