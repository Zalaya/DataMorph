package org.zalaya.dataset.utilities;

import org.zalaya.dataset.enumerators.ColumnType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ColumnTypeParser {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private ColumnTypeParser() {
        throw new IllegalStateException("Utility class");
    }

    public static Object parse(String value, ColumnType type) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Value cannot be null or blank");
        }

        return switch(type) {
            case NUMBER -> parseNumber(value);
            case STRING -> value;
            case DATE -> parseDate(value);
        };
    }

    private static Number parseNumber(String value) {
        try {
            if (value.contains(".")) {
                return Double.parseDouble(value);
            } else {
                return Integer.parseInt(value);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format");
        }
    }

    private static Date parseDate(String value) {
        try {
            return new SimpleDateFormat(DATE_FORMAT).parse(value);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }
    }

}
