package org.zalaya.dataset.utilities;

import org.zalaya.dataset.enumerators.ColumnType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ColumnTypeParser {

    private static final List<String> DATE_FORMATS = List.of(
        "yyyy-MM-dd",
        "yyyy-MM-dd'T'HH:mm:ss",
        "dd/MM/yyyy",
        "MM/dd/yyyy",
        "yyyy/MM/dd",
        "yyyyMMdd",
        "dd-MMM-yyyy",
        "MMM dd, yyyy"
    );

    private ColumnTypeParser() {
        throw new IllegalStateException("Utility classes cannot be instantiated");
    }

    public static Object parseValue(String value, ColumnType type) {
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
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.setLenient(false);

                return sdf.parse(value);
            } catch (ParseException e) {
                // Continue to the next format
            }
        }

        throw new IllegalArgumentException("Invalid date format");
    }

}
