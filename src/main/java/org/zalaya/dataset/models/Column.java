package org.zalaya.dataset.models;

import org.zalaya.dataset.enumerators.ColumnType;
import org.zalaya.dataset.utilities.ColumnTypeParser;

public record Column(String name, ColumnType type) {

    public Column {
        if (name == null || name.isBlank() || type == null) {
            throw new IllegalArgumentException("Column name and type must not be null or empty");
        }
    }

    public Object parseValue(String value) {
        return ColumnTypeParser.parseValue(value, type);
    }

}
