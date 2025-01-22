package org.zalaya.dataset.models;

public class Cell {

    private final Object value;

    public Cell(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        this.value = value;
    }

    public Object getValue() {
        return value;
    }

}
