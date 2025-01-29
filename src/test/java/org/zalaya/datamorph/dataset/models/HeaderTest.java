package org.zalaya.datamorph.dataset.models;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import org.zalaya.datamorph.dataset.enumerators.HeaderType;
import org.zalaya.datamorph.dataset.exceptions.HeaderValidationException;
import org.zalaya.datamorph.dataset.utilities.MockUtilities;

import static org.junit.jupiter.api.Assertions.assertThrows;

class HeaderTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" "})
    void shouldThrowExceptionWhenNameIsNullOrBlank(String name) {
        HeaderType type = MockUtilities.mockHeaderType(String.class);

        assertThrows(HeaderValidationException.class, () -> {
            new Header(name, type);
        });
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowExceptionWhenTypeIsNull(HeaderType type) {
        String name = "header";

        assertThrows(HeaderValidationException.class, () -> {
            new Header(name, type);
        });
    }

}