package org.zalaya.datamorph.dataset.models;

import org.zalaya.datamorph.dataset.exceptions.validation.DatasetValidationException;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public record Dataset(String name, List<Header> headers, List<Row> rows) {

    public Dataset {
        if (name == null || name.isBlank() || headers == null || headers.isEmpty()) {
            throw new DatasetValidationException("Dataset name and headers must not be null or empty");
        }

        validateHeaders(headers);
        validateRows(rows);
    }

    private void validateHeaders(List<Header> headers) {
        if (new HashSet<>(headers).size() != headers.size()) {
            throw new DatasetValidationException("Dataset headers must be unique");
        }
    }

    private void validateRows(List<Row> rows) {
        for (Row row : rows) {
            if (row.headers().equals(headers)) {
                throw new DatasetValidationException("Row headers must match the dataset headers");
            }
        }
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
