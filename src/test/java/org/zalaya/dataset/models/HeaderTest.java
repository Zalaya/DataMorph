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
    public void shouldInstantiateHeaderWhenNameAndTypeAreValid() {
        String name = "name";
        HeaderType type = HeaderType.STRING;

        Header header = new Header(name, type);

        assertEquals(name, header.name());
        assertEquals(type, header.type());
    }

    @Test
    public void shouldBuildHeaderWhenNameAndTypeAreValid() {
        String name = "name";
        HeaderType type = HeaderType.STRING;

        Header header = Header.builder()
            .name(name)
            .type(type)
            .build();

        assertEquals(name, header.name());
        assertEquals(type, header.type());
    }

}
