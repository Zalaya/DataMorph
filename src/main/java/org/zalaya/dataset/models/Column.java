package org.zalaya.dataset.models;

import org.zalaya.dataset.enumerators.ColumnType;
import org.zalaya.dataset.utilities.ColumnTypeParser;

public class Column {

    private final String name;
    private final ColumnType type;

    public Column(String name, ColumnType type) {
        if (name == null || name.isBlank() || type == null) {
            throw new IllegalArgumentException("Column name and type must not be null or empty");
        }

        this.name = name;
        this.type = type;
    }

    public Object parseValue(String value) {
        return ColumnTypeParser.parseValue(value, type);
    }

    public String getName() {
        return name;
    }

    public ColumnType getType() {
        return type;
    }

}
