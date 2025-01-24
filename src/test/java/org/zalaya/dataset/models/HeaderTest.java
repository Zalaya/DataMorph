package org.zalaya.dataset.models;

import org.junit.jupiter.api.Test;

import org.zalaya.dataset.enumerators.HeaderType;
import org.zalaya.dataset.exceptions.InvalidHeaderException;

import static org.junit.jupiter.api.Assertions.*;

public class HeaderTest {

    @Test
    public void shouldThrowExceptionWhenNameIsNull() {
        String name = null;
        HeaderType type = HeaderType.STRING;

        assertThrows(InvalidHeaderException.class, () -> {
            new Header(name, type);
        });
    }

    @Test
    public void shouldThrowExceptionWhenNameIsEmpty() {
        String name = "";
        HeaderType type = HeaderType.STRING;

        assertThrows(InvalidHeaderException.class, () -> {
            new Header(name, type);
        });
    }

    @Test
    public void shouldThrowExceptionWhenNameIsBlank() {
        String name = " ";
        HeaderType type = HeaderType.STRING;

        assertThrows(InvalidHeaderException.class, () -> {
            new Header(name, type);
        });
    }

    @Test
    public void shouldThrowExceptionWhenTypeIsNull() {
        String name = "name";
        HeaderType type = null;

        assertThrows(InvalidHeaderException.class, () -> {
            new Header(name, type);
        });
    }

    @Test
    public void shouldReturnTrueWhenComparingHeadersWithSameName() {
        String name = "name";
        HeaderType type = HeaderType.STRING;

        Header header1 = new Header(name, type);
        Header header2 = new Header(name, type);

        assertEquals(header1, header2);
    }

    @Test
    public void shouldReturnTrueWhenComparingHeadersWithSameNameAndDifferentType() {
        String name = "name";
        HeaderType type1 = HeaderType.STRING;
        HeaderType type2 = HeaderType.NUMBER;

        Header header1 = new Header(name, type1);
        Header header2 = new Header(name, type2);

        assertEquals(header1, header2);
    }

    @Test
    public void shouldReturnFalseWhenComparingHeadersWithDifferentName() {
        String name1 = "name1";
        String name2 = "name2";
        HeaderType type = HeaderType.STRING;

        Header header1 = new Header(name1, type);
        Header header2 = new Header(name2, type);

        assertNotEquals(header1, header2);
    }

}