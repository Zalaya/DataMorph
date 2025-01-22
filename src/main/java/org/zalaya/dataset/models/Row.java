package org.zalaya.dataset.models;

import java.util.Map;

public class Row {

    private final Map<Header, Cell> cells;

    public Row(Map<Header, Cell> cells) {
        if (cells == null || cells.isEmpty()) {
            throw new IllegalArgumentException("Row cells cannot be null or empty");
        }

        this.cells = cells;
    }

    public Map<Header, Cell> getCells() {
        return cells;
    }

}
