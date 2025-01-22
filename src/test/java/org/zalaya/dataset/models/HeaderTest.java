package org.zalaya.dataset.models;

import org.junit.jupiter.api.Test;
import org.zalaya.dataset.enumerators.HeaderType;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class HeaderTest {

    @Test
    public void shouldThrowExceptionWhenNameIsNull() {
        String name = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new Header(name, HeaderType.STRING);
        });
    }

    @Test
    public void shouldThrowExceptionWhenNameIsEmpty() {
        String name = "";

        assertThrows(IllegalArgumentException.class, () -> {
            new Header(name, HeaderType.STRING);
        });
    }

    @Test
    public void shouldThrowExceptionWhenTypeIsNull() {
        HeaderType type = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new Header("name", type);
        });
    }

}
