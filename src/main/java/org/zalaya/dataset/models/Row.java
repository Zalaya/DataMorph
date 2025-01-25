package org.zalaya.dataset.models;

import org.zalaya.dataset.annotations.Entity;
import org.zalaya.dataset.builders.RowBuilder;
import org.zalaya.dataset.exceptions.InvalidRowException;
import org.zalaya.dataset.exceptions.TypeMismatchException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@Entity
public record Row(LinkedHashMap<Header, Cell> cells) {

    public Row {
        if (cells == null || cells.isEmpty()) {
            throw new InvalidRowException("Row cells must not be null or empty");
        }

        validateCells(cells);
    }

    public static RowBuilder builder() {
        return new RowBuilder();
    }

    private void validateCells(Map<Header, Cell> cells) {
        cells.forEach((header, value) -> {
            if (value != null && !value.isValid(header)) {
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
