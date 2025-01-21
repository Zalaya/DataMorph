package org.zalaya.dataset.models;

import java.util.List;

public class Row {

    private final List<Cell> cells;

    public Row(List<Cell> cells) {
        if (cells == null || cells.isEmpty()) {
            throw new IllegalArgumentException("Row must have at least one cell");
        }

        this.cells = cells;
    }

    public List<Cell> getCells() {
        return cells;
    }

}
