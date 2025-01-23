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
    public void shouldReturnTrueWhenComparingTwoHeadersWithTheSameName() {
        String name = "name";
        HeaderType type = HeaderType.STRING;

        Header header1 = new Header(name, type);
        Header header2 = new Header(name, type);

        assertEquals(header1, header2);
    }

    @Test
    public void shouldReturnFalseWhenComparingTwoHeadersWithDifferentNames() {
        String name1 = "name1";
        String name2 = "name2";
        HeaderType type = HeaderType.STRING;

        Header header1 = new Header(name1, type);
        Header header2 = new Header(name2, type);

        assertNotEquals(header1, header2);
    }

    @Test
    public void shouldReturnTrueWhenTwoHeadersHaveTheSameHashCode() {
        String name = "name";
        HeaderType type = HeaderType.STRING;

        Header header1 = new Header(name, type);
        Header header2 = new Header(name, type);

        assertEquals(header1.hashCode(), header2.hashCode());
    }

    @Test
    public void shouldReturnFalseWhenTwoHeadersHaveDifferentHashCodes() {
        String name1 = "name1";
        String name2 = "name2";
        HeaderType type = HeaderType.STRING;

        Header header1 = new Header(name1, type);
        Header header2 = new Header(name2, type);

        assertNotEquals(header1.hashCode(), header2.hashCode());
    }

}
