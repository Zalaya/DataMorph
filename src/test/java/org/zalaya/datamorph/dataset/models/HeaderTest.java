package org.zalaya.datamorph.dataset.models;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.zalaya.datamorph.dataset.enumerators.HeaderType;
import org.zalaya.datamorph.dataset.exceptions.validation.HeaderValidationException;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.zalaya.datamorph.dataset.utilities.MockUtilities.mockHeaderType;

class HeaderTest {

    @Test
    void shouldCreateHeaderWithValidAttributes() {
        String name = "name";
        HeaderType type = mockHeaderType(String.class);
        Header header = new Header(name, type);

        assertEquals(name, header.getName());
        assertEquals(type, header.getType());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowExceptionWhenNameIsNullOrEmpty(String name) {
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
