package org.zalaya.dataset.models;

import org.junit.jupiter.api.Test;
import org.zalaya.dataset.enumerators.HeaderType;
import org.zalaya.dataset.exceptions.InvalidHeaderException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class HeaderBuilderTest {

    @Test
    public void shouldThrowExceptionWhenNameIsNull() {
        String name = null;
        HeaderType type = HeaderType.STRING;

        assertThrows(InvalidHeaderException.class, () -> {
            new HeaderBuilder()
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
            new HeaderBuilder()
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
            new HeaderBuilder()
                .name(name)
                .type(type)
                .build();
        });
    }

    @Test
    public void shouldThrowExceptionWhenTypeIsNull() {
        String name = "name";
        HeaderType type = null;

        assertThrows(InvalidHeaderException.class, () -> {
            new HeaderBuilder()
                .name(name)
                .type(type)
                .build();
        });
    }

}
