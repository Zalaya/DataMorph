package org.zalaya.dataset.models;

import java.util.List;

public record Row(List<Cell> cells) {

    public Row {
        if (cells == null || cells.isEmpty()) {
            throw new IllegalArgumentException("Row must have at least one cell");
        }
    }

}
