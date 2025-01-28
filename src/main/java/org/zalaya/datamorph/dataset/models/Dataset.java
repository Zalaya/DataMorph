package org.zalaya.datamorph.dataset.models;

import org.zalaya.datamorph.dataset.annotations.AggregateRoot;
import org.zalaya.datamorph.dataset.exceptions.InvalidDatasetException;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@AggregateRoot
public record Dataset(String name, Set<Header> headers, List<Row> rows) {

    public Dataset {
        if (name == null || name.isBlank() || headers == null || headers.isEmpty()) {
            throw new InvalidDatasetException("Dataset name and headers must not be null or empty");
        }

        validateRows(rows);
    }

    private void validateRows(List<Row> rows) {
        rows.forEach(row -> {
            if (!row.cells().keySet().equals(headers)) {
                throw new InvalidDatasetException("Dataset row headers must match the dataset headers");
            }
        });
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Dataset dataset)) {
            return false;
        }

        return Objects.equals(name, dataset.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}
