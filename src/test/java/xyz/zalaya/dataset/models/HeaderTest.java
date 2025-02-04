package xyz.zalaya.dataset.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import xyz.zalaya.dataset.enumerators.HeaderType;
import xyz.zalaya.dataset.exceptions.validation.HeaderValidationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static xyz.zalaya.dataset.utilities.MockUtilities.mockHeaderType;

class HeaderTest {

    @Test
    void shouldCreateHeaderWithValidAttributes() {
        String name = "header";
        HeaderType type = mockHeaderType(String.class);
        Header header = new Header(name, type);

        assertEquals(name, header.getName());
        assertEquals(type, header.getType());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowExceptionWhenNameIsNullOrBlank(String name) {
        HeaderType type = mockHeaderType(String.class);

        assertThrows(HeaderValidationException.class, () -> {
            new Header(name, type);
        });
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowExceptionWhenTypeIsNull(HeaderType type) {
        String name = "name";

        assertThrows(HeaderValidationException.class, () -> {
            new Header(name, type);
        });
    }

}
