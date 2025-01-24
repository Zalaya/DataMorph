package org.zalaya.dataset.builders;

import org.junit.jupiter.api.Test;

import org.zalaya.dataset.enumerators.HeaderType;
import org.zalaya.dataset.exceptions.InvalidHeaderException;
import org.zalaya.dataset.models.Header;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class HeaderBuilderTest {

    @Test
    public void shouldThrowExceptionWhenNameIsNull() {
        String name = null;
        HeaderType type = HeaderType.STRING;

        assertThrows(InvalidHeaderException.class, () -> {
            Header.builder()
                .name(name)
                .type(type)
                .build();
        });
    }

    @Test
    public void shouldThrowExceptionWhenNameIsEmpty() {
        String name = "";
        HeaderType type = HeaderType.STRING;

        assertThrows(InvalidHeaderException.class, () -> {
            Header.builder()
                .name(name)
                .type(type)
                .build();
        });
    }

    @Test
    public void shouldThrowExceptionWhenNameIsBlank() {
        String name = " ";
        HeaderType type = HeaderType.STRING;

        assertThrows(InvalidHeaderException.class, () -> {
            Header.builder()
                .name(name)
                .type(type)
                .build();
        });
    }

    @Test
    public void shouldThrowExceptionWhenTypeIsNull() {
        String name = "header";
        HeaderType type = null;

        assertThrows(InvalidHeaderException.class, () -> {
            Header.builder()
                .name(name)
                .type(type)
                .build();
        });
    }

}
