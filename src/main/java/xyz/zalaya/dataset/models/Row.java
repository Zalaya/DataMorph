package xyz.zalaya.dataset.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import xyz.zalaya.dataset.exceptions.HeaderTypeMismatchException;
import xyz.zalaya.dataset.exceptions.RowValidationException;

import java.util.List;

@Getter
@EqualsAndHashCode
public class Row {

    private final List<Object> cells;

    public Row(List<Header> headers, List<Object> cells) {
        this.cells = validateCells(headers, cells);
    }

    /**
     * Validates the row cells.
     *
     * @param cells The row cells to validate.
     * @return The validated row cells.
     * @throws RowValidationException If the row cells are null or do not match the number of headers.
     * @throws HeaderTypeMismatchException If the row cell type does not match the header type.
     */
    private List<Object> validateCells(List<Header> headers, List<Object> cells) {
        if (cells == null || headers.size() != cells.size()) {
            throw new RowValidationException("Row cells must not be null and must match the number of headers");
        }

        for (int i = 0; i < headers.size(); i++) {
            if (!headers.get(i).getType().getType().isAssignableFrom(cells.get(i).getClass())) {
                throw new HeaderTypeMismatchException("Row cell type must match the header type");
            }
        }

        return cells;
    }

}