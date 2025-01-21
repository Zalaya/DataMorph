package org.zalaya.dataset.models;

import org.zalaya.dataset.enumerators.ColumnType;
import org.zalaya.dataset.utilities.ColumnTypeParser;

public class Column {

    private final String name;
    private final ColumnType type;

    public Column(String name, ColumnType type) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Column name cannot be null or blank");
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
