package org.zalaya.dataset.models;

import org.zalaya.dataset.annotations.AggregateRoot;
import org.zalaya.dataset.exceptions.InvalidDatasetException;

import java.util.List;
import java.util.Set;

@AggregateRoot
public record Dataset(Set<Header> headers, List<Row> rows) {

    public Dataset {
        if (headers == null || rows == null) {
            throw new InvalidDatasetException("Dataset headers and rows must not be null");
        }
    }

    public static Dataset withEmptyHeaders(List<Row> rows) {
        return new Dataset(Set.of(), rows);
    }

    public static Dataset withEmptyRows(Set<Header> headers) {
        return new Dataset(headers, List.of());
    }

}
