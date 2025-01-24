package org.zalaya.dataset.models;

import org.zalaya.dataset.builders.RowBuilder;
import org.zalaya.dataset.exceptions.InvalidRowException;
import org.zalaya.dataset.exceptions.TypeMismatchException;

import java.util.LinkedHashMap;
import java.util.Objects;

public record Row(LinkedHashMap<Header, Object> cells) {

    public Row {
        if (cells == null) {
            throw new InvalidRowException("Row cells must not be null");
        }

        validateCells(cells);
    }

    public static RowBuilder builder() {
        return new RowBuilder();
    }

    private void validateCells(LinkedHashMap<Header, Object> cells) {
        cells.forEach((header, value) -> {
            if (value != null && !header.type().getType().isInstance(value)) {
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
