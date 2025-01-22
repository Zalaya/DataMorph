package org.zalaya.dataset.utilities;

import org.junit.jupiter.api.Test;

import org.zalaya.dataset.enumerators.HeaderType;

import java.time.LocalDate;
import java.time.ZoneId;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CellTypeParserTest {

    @Test
    public void shouldThrowExceptionWhenParsingNullString() {
        String value = null;

        assertThrows(IllegalArgumentException.class, () -> {
            CellTypeParser.parseValue(value, HeaderType.STRING);
        });
    }

    @Test
    public void shouldThrowExceptionWhenParsingNullNumber() {
        String value = null;

        assertThrows(IllegalArgumentException.class, () -> {
            CellTypeParser.parseValue(value, HeaderType.NUMBER);
        });
    }

    @Test
    public void shouldThrowExceptionWhenParsingNullDate() {
        String value = null;

        assertThrows(IllegalArgumentException.class, () -> {
            CellTypeParser.parseValue(value, HeaderType.DATE);
        });
    }

    @Test
    public void shouldParseString() {
        String value = "Hello";
        Object expectedValue = "Hello";

        assertEquals(expectedValue, CellTypeParser.parseValue(value, HeaderType.STRING));
    }

    @Test
    public void shouldParseIntegerNumber() {
        String value = "123";
        Object expectedValue = 123;

        assertEquals(expectedValue, CellTypeParser.parseValue(value, HeaderType.NUMBER));
    }

    @Test
    public void shouldParseDoubleNumber() {
        String value = "123.45";
        Object expectedValue = 123.45;

        assertEquals(expectedValue, CellTypeParser.parseValue(value, HeaderType.NUMBER));
    }

    @Test
    public void shouldThrowExceptionWhenParsingMalformedNumber() {
        String value = "123.45.67";

        assertThrows(IllegalArgumentException.class, () -> {
            CellTypeParser.parseValue(value, HeaderType.NUMBER);
        });
    }

    @Test
    public void shouldThrowExceptionWhenParsingInvalidNumber() {
        String value = "Hello";

        assertThrows(IllegalArgumentException.class, () -> {
            CellTypeParser.parseValue(value, HeaderType.NUMBER);
        });
    }

    @Test
    public void shouldParseISO8601Date() {
        String value = "2021-01-01";
        Date expectedValue = Date.from(LocalDate.of(2021, 1, 1)
            .atStartOfDay(ZoneId.of("UTC"))
            .toInstant());

        assertEquals(expectedValue, CellTypeParser.parseValue(value, HeaderType.DATE));
    }

    @Test
    public void shouldParseEuropeanDate() {
        String value = "21/01/2021";
        Date expectedValue = Date.from(LocalDate.of(2021, 1, 21)
            .atStartOfDay(ZoneId.of("UTC"))
            .toInstant());

        assertEquals(expectedValue, CellTypeParser.parseValue(value, HeaderType.DATE));
    }

    @Test
    public void shouldParseAmericanDate() {
        String value = "01/21/2021";
        Date expectedValue = Date.from(LocalDate.of(2021, 1, 21)
            .atStartOfDay(ZoneId.of("UTC"))
            .toInstant());

        assertEquals(expectedValue, CellTypeParser.parseValue(value, HeaderType.DATE));
    }

    @Test
    public void shouldParseAsianDate() {
        String value = "2021/01/21";
        Date expectedValue = Date.from(LocalDate.of(2021, 1, 21)
            .atStartOfDay(ZoneId.of("UTC"))
            .toInstant());

        assertEquals(expectedValue, CellTypeParser.parseValue(value, HeaderType.DATE));
    }

    @Test
    public void shouldThrowExceptionWhenParsingInvalidDate() {
        String value = "2021/51/21";

        assertThrows(IllegalArgumentException.class, () -> {
            CellTypeParser.parseValue(value, HeaderType.DATE);
        });
    }

}
