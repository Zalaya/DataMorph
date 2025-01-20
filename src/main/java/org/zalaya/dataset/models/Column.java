package org.zalaya.dataset.models;

public class Column {

    private final String name;

    public Column(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Column name cannot be null or blank");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

}
