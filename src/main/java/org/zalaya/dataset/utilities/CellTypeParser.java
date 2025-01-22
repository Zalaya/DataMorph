package org.zalaya.dataset.utilities;

import org.zalaya.dataset.enumerators.HeaderType;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class CellTypeParser {

    private static final List<String> DATE_FORMATS = List.of(
        "yyyy-MM-dd",
        "dd/MM/yyyy",
        "MM/dd/yyyy",
        "yyyy/MM/dd"
    );

    private CellTypeParser() {
        throw new IllegalStateException("Utility classes cannot be instantiated");
    }

    public static Object parseValue(String value, HeaderType type) {
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
        for (String format: DATE_FORMATS) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat(format);
                formatter.setLenient(false);
                formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

                return formatter.parse(value);
            } catch (ParseException e) {
                // Continue to the next format
            }
        }

        throw new IllegalArgumentException("Invalid date format");
    }

}
