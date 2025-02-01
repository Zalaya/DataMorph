package org.zalaya.datamorph.dataset.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@EqualsAndHashCode
public class Row {

    private final List<Object> cells;

    public Row(List<Object> cells) {
        this.cells = validateCells(cells);
    }

    /**
     * Validates the row cells.
     *
     * @param cells The row cells to validate.
     * @return The validated row cells.
     */
    private List<Object> validateCells(List<Object> cells) {
        if (cells == null) {
            throw new IllegalArgumentException("Row cells must not be null");
        }

        return cells;
    }

}
