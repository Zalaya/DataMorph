package org.zalaya.datamorph.dataset.models;

import org.zalaya.datamorph.dataset.exceptions.TypeMismatchException;
import org.zalaya.datamorph.dataset.exceptions.validation.RowValidationException;

import java.util.List;

public record Row(List<Header> headers, List<Object> cells) {

    public Row {
        if (headers == null || headers.isEmpty() || cells == null || cells.isEmpty()) {
            throw new RowValidationException("Row cells must not be null or empty");
        }

        validateCells(headers, cells);
    }

    private void validateCells(List<Header> headers, List<Object> cells) {
        if (headers.size() != cells.size()) {
            throw new RowValidationException("Row cells must match the row headers");
        }

        for (int i = 0; i < headers.size(); i++) {
            if (!headers.get(i).type().type().isInstance(cells.get(i))) {
                throw new TypeMismatchException("Row cell type must match the row header type");
            }
        }
    }

}
