package xyz.zalaya.dataset.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import xyz.zalaya.dataset.exceptions.HeaderTypeMismatchException;
import xyz.zalaya.dataset.exceptions.validation.RowValidationException;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Getter
@EqualsAndHashCode
public class Row {

    private final List<Object> cells;

    public Row(Set<Header> headers, List<Object> cells) {
        this.cells = validateCells(headers, cells);
    }

    /**
     * Validates the row cells.
     *
     * @param cells The row cells to validate.
     * @return The validated row cells.
     */
    private List<Object> validateCells(Set<Header> headers, List<Object> cells) {
        if (cells == null || headers.size() != cells.size()) {
            throw new RowValidationException("Row cells must not be null and must match the number of headers");
        }

        Iterator<Header> iterator = headers.iterator();

        for (int i = 0; iterator.hasNext(); i++) {
            if (!iterator.next().getType().isInstance(cells.get(i))) {
                throw new HeaderTypeMismatchException("Row cell type must match the header type");
            }
        }

        return cells;
    }

}