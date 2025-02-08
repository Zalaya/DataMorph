package xyz.zalaya.dataset.models;

import org.junit.jupiter.api.Test;

import xyz.zalaya.dataset.enumerators.HeaderType;
import xyz.zalaya.dataset.mocks.MockHeaderType;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class HeaderTest {

    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        String name = null;
        HeaderType type = MockHeaderType.STRING;

        assertThrows(IllegalArgumentException.class, () -> {
            new Header(name, type);
        });
    }

    @Test
    void shouldThrowExceptionWhenNameIsEmpty() {
        String name = "";
        HeaderType type = MockHeaderType.STRING;

        assertThrows(IllegalArgumentException.class, () -> {
            new Header(name, type);
        });
    }

    @Test
    void shouldThrowExceptionWhenNameIsBlank() {
        String name = " ";
        HeaderType type = MockHeaderType.STRING;

        assertThrows(IllegalArgumentException.class, () -> {
            new Header(name, type);
        });
    }

}
