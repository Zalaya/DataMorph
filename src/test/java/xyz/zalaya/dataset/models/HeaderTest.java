package xyz.zalaya.dataset.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import xyz.zalaya.dataset.enumerators.HeaderType;
import xyz.zalaya.dataset.exceptions.HeaderValidationException;
import xyz.zalaya.dataset.mocks.MockHeaderType;

import static org.junit.jupiter.api.Assertions.*;

class HeaderTest {

    @Test
    void shouldCreateHeaderWithValidAttributes() {
        String name = "header";
        HeaderType type = MockHeaderType.STRING;
        Header header = new Header(name, type);

        assertEquals(name, header.getName());
        assertEquals(type, header.getType());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowExceptionWhenNameIsNullOrBlank(String name) {
        HeaderType type = MockHeaderType.STRING;

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

    @Test
    void shouldReturnTrueWhenComparingHeadersWithSameName() {
        Header header1 = new Header("header", MockHeaderType.STRING);
        Header header2 = new Header("header", MockHeaderType.STRING);

        assertEquals(header1, header2);
    }

    @Test
    void shouldReturnFalseWhenComparingHeadersWithDifferentName() {
        Header header1 = new Header("header1", MockHeaderType.STRING);
        Header header2 = new Header("header2", MockHeaderType.STRING);

        assertNotEquals(header1, header2);
    }

}
