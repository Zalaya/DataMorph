package org.zalaya.dataset.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.zalaya.dataset.enumerators.HeaderType;
import org.zalaya.dataset.exceptions.InvalidHeaderException;

import static org.junit.jupiter.api.Assertions.*;

class HeaderTest {

    private HeaderType type;

    @BeforeEach
    void setUp() {
        type = HeaderType.STRING;
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { " " })
    void shouldThrowExceptionWhenNameIsNullOrBlank(String name) {
        assertThrows(InvalidHeaderException.class, () -> {
            new Header(name, type);
        });
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowExceptionWhenTypeIsNull(HeaderType type) {
        String name = "header";

        assertThrows(InvalidHeaderException.class, () -> {
            new Header(name, type);
        });
    }

    @Test
    void shouldReturnTrueWhenComparingHeadersWithSameName() {
        String name = "header";
        Header header1 = new Header(name, type);
        Header header2 = new Header(name, type);

        assertEquals(header1, header2);
    }

    @Test
    void shouldReturnFalseWhenComparingHeadersWithDifferentName() {
        String name1 = "header1";
        String name2 = "header2";
        Header header1 = new Header(name1, type);
        Header header2 = new Header(name2, type);

        assertNotEquals(header1, header2);
    }

}