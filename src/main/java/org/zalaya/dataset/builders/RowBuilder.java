package org.zalaya.dataset.builders;

import org.zalaya.dataset.models.Header;
import org.zalaya.dataset.models.Row;

import java.util.LinkedHashMap;
import java.util.Map;

public class RowBuilder {

    private LinkedHashMap<Header, Object> cells = new LinkedHashMap<>();

    public RowBuilder cell(Header header, Object value) {
        cells.put(header, value);
        return this;
    }

    public RowBuilder cells(Map<Header, Object> cells) {
        this.cells = !this.cells.isEmpty() ? new LinkedHashMap<>(cells) : new LinkedHashMap<>();
        return this;
    }

    public Row build() {
        return new Row(cells);
    }

}
