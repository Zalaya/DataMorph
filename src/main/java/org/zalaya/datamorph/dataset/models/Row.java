package org.zalaya.datamorph.dataset.models;

import org.zalaya.datamorph.dataset.annotations.Entity;
import org.zalaya.datamorph.dataset.exceptions.TypeMismatchException;
import org.zalaya.datamorph.dataset.exceptions.RowValidationException;

import java.util.LinkedHashMap;
import java.util.Objects;

@Entity
public record Row(LinkedHashMap<Header, Object> cells) {

    public Row {
        if (cells == null || cells.isEmpty()) {
            throw new RowValidationException("Row cells must not be null or empty");
        }

        validateCells(cells);
    }

    private void validateCells(LinkedHashMap<Header, Object> cells) {
        cells.forEach((header, cell) -> {
            if (cell != null && !header.type().getType().isInstance(cell)) {
                throw new TypeMismatchException("Cell value does not match the expected type");
            }
        });
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Row row)) {
            return false;
        }

        return Objects.equals(cells, row.cells);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cells);
    }

}
