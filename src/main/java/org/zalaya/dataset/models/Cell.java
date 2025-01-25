package org.zalaya.dataset.models;

import org.zalaya.dataset.annotations.Entity;

import java.util.Objects;

@Entity
public record Cell(Object value) {

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
