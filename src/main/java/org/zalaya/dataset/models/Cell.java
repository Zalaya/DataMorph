package org.zalaya.dataset.models;

public record Cell(Object value) {

    public Cell {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
    }

}
