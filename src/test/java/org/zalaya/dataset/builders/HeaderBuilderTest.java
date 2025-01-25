package org.zalaya.dataset.builders;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import org.zalaya.dataset.enumerators.HeaderType;
import org.zalaya.dataset.exceptions.InvalidHeaderException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class HeaderBuilderTest {

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowExceptionWhenNameIsNullOrEmpty(String name) {
        HeaderType type = HeaderType.STRING;
        HeaderBuilder builder = new HeaderBuilder();
        builder.name(name);
        builder.type(type);

        assertThrows(InvalidHeaderException.class, builder::build);
    }

    @Test
    void shouldThrowExceptionWhenNameIsBlank() {
        String name = " ";
        HeaderType type = HeaderType.STRING;
        HeaderBuilder builder = new HeaderBuilder();
        builder.name(name);
        builder.type(type);

        assertThrows(InvalidHeaderException.class, builder::build);
    }

    @Test
    void shouldThrowExceptionWhenTypeIsNull() {
        String name = "header";
        HeaderType type = null;
        HeaderBuilder builder = new HeaderBuilder();
        builder.name(name);
        builder.type(type);

        assertThrows(InvalidHeaderException.class, builder::build);
    }

}
