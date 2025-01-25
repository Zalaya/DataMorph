package org.zalaya.dataset.builders;

import org.zalaya.dataset.models.Cell;

public class CellBuilder {

    private Object value;

    public CellBuilder value(Object value) {
        this.value = value;
        return this;
    }

    public Cell build() {
        return new Cell(value);
    }

}
