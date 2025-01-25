package org.zalaya.dataset.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import org.zalaya.dataset.enumerators.HeaderType;
import org.zalaya.dataset.exceptions.InvalidHeaderException;

import static org.junit.jupiter.api.Assertions.*;

class HeaderTest {

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowExceptionWhenNameIsNullOrEmpty(String name) {
        HeaderType type = HeaderType.STRING;

        assertThrows(InvalidHeaderException.class, () -> {
            new Header(name, type);
        });
    }

    @Test
    void shouldThrowExceptionWhenNameIsBlank() {
        String name = " ";
        HeaderType type = HeaderType.STRING;

        assertThrows(InvalidHeaderException.class, () -> {
            new Header(name, type);
        });
    }

    @Test
    void shouldThrowExceptionWhenTypeIsNull() {
        String name = "header";
        HeaderType type = null;

        assertThrows(InvalidHeaderException.class, () -> {
            new Header(name, type);
        });
    }

    @Test
    void shouldReturnTrueWhenComparingHeadersWithSameName() {
        String name = "header";
        HeaderType type = HeaderType.STRING;

        Header header1 = new Header(name, type);
        Header header2 = new Header(name, type);

        assertEquals(header1, header2);
    }

    @Test
    void shouldReturnTrueWhenComparingHeadersWithSameNameAndDifferentType() {
        String name = "header";
        HeaderType type1 = HeaderType.STRING;
        HeaderType type2 = HeaderType.NUMBER;

        Header header1 = new Header(name, type1);
        Header header2 = new Header(name, type2);

        assertEquals(header1, header2);
    }

    @Test
    void shouldReturnFalseWhenComparingHeadersWithDifferentName() {
        String name1 = "header1";
        String name2 = "header2";
        HeaderType type = HeaderType.STRING;

        Header header1 = new Header(name1, type);
        Header header2 = new Header(name2, type);

        assertNotEquals(header1, header2);
    }

}