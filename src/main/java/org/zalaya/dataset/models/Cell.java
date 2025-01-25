package org.zalaya.dataset.models;

import org.zalaya.dataset.annotations.Entity;
import org.zalaya.dataset.builders.CellBuilder;
import org.zalaya.dataset.exceptions.InvalidCellException;

import java.util.Objects;

@Entity
public record Cell(Object value) {

    public Cell {
        if (value == null) {
            throw new InvalidCellException("Cell value must not be null");
        }
    }

    public boolean isValid(Header header) {
        return header.type().getType().isInstance(value);
    }

    public static CellBuilder builder() {
        return new CellBuilder();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cell cell)) {
            return false;
        }

        return Objects.equals(value, cell.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

}
