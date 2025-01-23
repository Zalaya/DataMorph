package org.zalaya.dataset.models;

import org.junit.jupiter.api.Test;
import org.zalaya.dataset.enumerators.HeaderType;

import static org.junit.jupiter.api.Assertions.*;

public class HeaderTest {

    @Test
    public void shouldThrowExceptionWhenNameIsNull() {
        String name = null;
        HeaderType type = HeaderType.STRING;

        assertThrows(IllegalArgumentException.class, () -> {
            new Header(name, type);
        });
    }

    @Test
    public void shouldThrowExceptionWhenNameIsEmpty() {
        String name = "";
        HeaderType type = HeaderType.STRING;

        assertThrows(IllegalArgumentException.class, () -> {
            new Header(name, type);
        });
    }

    @Test
    public void shouldThrowExceptionWhenNameIsBlank() {
        String name = " ";
        HeaderType type = HeaderType.STRING;

        assertThrows(IllegalArgumentException.class, () -> {
            new Header(name, type);
        });
    }

    @Test
    public void shouldThrowExceptionWhenTypeIsNull() {
        String name = "name";
        HeaderType type = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new Header(name, type);
        });
    }

    @Test
    public void shouldCreateHeaderWithValidNameAndType() {
        String name = "name";
        HeaderType type = HeaderType.STRING;

        Header header = new Header(name, type);
    }

    @Test
    public void shouldCreateHeaderWithValidNameAndTypeUsingBuilder() {
        String name = "name";
        HeaderType type = HeaderType.STRING;

        Header header = Header.builder()
            .name(name)
            .type(type)
            .build();

        assertEquals(name, header.getName());
        assertEquals(type, header.getType());
    }

    @Test
    public void shouldReturnTrueWhenTwoHeadersAreEqual() {
        String name = "name";
        HeaderType type = HeaderType.STRING;

        Header header1 = new Header(name, type);
        Header header2 = new Header(name, type);

        assertEquals(header1, header2);
    }

    @Test
    public void shouldReturnFalseWhenTwoHeadersAreNotEqual() {
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
