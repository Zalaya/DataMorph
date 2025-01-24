package org.zalaya.dataset.builders;

import org.zalaya.dataset.models.Header;
import org.zalaya.dataset.models.Row;

import java.util.LinkedHashMap;

public class RowBuilder {

    private LinkedHashMap<Header, Object> cells;

    public RowBuilder cells(LinkedHashMap<Header, Object> cells) {
        this.cells = cells;
        return this;
    }

    public Row build() {
        return new Row(cells);
    }

}
