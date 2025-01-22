package org.zalaya.dataset.models;

import java.util.Map;

public class Row {

    private final Map<Header, Cell> cells;

    public Row(Map<Header, Cell> cells) {
        if (cells == null) {
            throw new IllegalArgumentException("Row cells cannot be null");
        }

        this.cells = cells;
    }

    public Row() {
        this.cells = Map.of();
    }

    public void addCell(Header header, Cell cell) {
        if (header == null || cell == null) {
            throw new IllegalArgumentException("Row header and cell cannot be null");
        }

        if (cell.getClass() != header.getType().getClazz()) {
            throw new IllegalArgumentException("Row cell type does not match header type");
        }

        cells.put(header, cell);
    }

    public Map<Header, Cell> getCells() {
        return cells;
    }

}
