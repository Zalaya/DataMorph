package org.zalaya.dataset.utilities;

import org.junit.jupiter.api.Test;
import org.zalaya.dataset.enumerators.ColumnType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ColumnTypeParserTest {

    @Test
    public void shouldParseString() {
        String value = "Hello";
        Object expectedValue = "Hello";

        assertEquals(expectedValue, ColumnTypeParser.parseValue(value, ColumnType.STRING));
    }

    @Test
    public void shouldParseNumber() {
        String value = "123";
        Object expectedValue = 123;

        assertEquals(expectedValue, ColumnTypeParser.parseValue(value, ColumnType.NUMBER));
    }

    @Test
    public void shouldParseIntegerNumber() {
        String value = "123";
        Object expectedValue = 123;

        assertEquals(expectedValue, ColumnTypeParser.parseValue(value, ColumnType.NUMBER));
    }

    @Test
    public void shouldParseDoubleNumber() {
        String value = "123.45";
        Object expectedValue = 123.45;

        assertEquals(expectedValue, ColumnTypeParser.parseValue(value, ColumnType.NUMBER));
    }

    @Test
    public void shouldThrowExceptionWhenParsingInvalidNumber() {
        String value = "123.45.67";

        assertThrows(IllegalArgumentException.class, () -> {
            ColumnTypeParser.parseValue(value, ColumnType.NUMBER);
        });
    }

    // TODO: Add tests for parsing dates

}
