package xyz.zalaya.dataset.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@EqualsAndHashCode
public class Row {

    private final List<Object> cells;

    public Row(List<Header> headers, List<Object> cells) {
        this.cells = validateCells(headers, cells);
    }
    
    private List<Object> validateCells(List<Header> headers, List<Object> cells) {
        if (cells == null || headers.size() != cells.size()) {
            throw new IllegalArgumentException("Row cells must not be null and must match the number of headers");
        }

        for (int i = 0; i < headers.size(); i++) {
            if (!headers.get(i).getType().getType().isAssignableFrom(cells.get(i).getClass())) {
                throw new IllegalArgumentException("Row cell type must match the header type");
            }
        }

        return cells;
    }

}