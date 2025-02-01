package org.zalaya.datamorph.dataset.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
@Builder
@EqualsAndHashCode(exclude = {"headers", "rows"})
public class Dataset {

    private final String name;
    private final Set<Header> headers;
    private final List<Row> rows;

    public Dataset(String name, Set<Header> headers, List<Row> rows) {
        this.name = validateName(name);
        this.headers = validateHeaders(headers);
        this.rows = validateRows(rows);
    }

    /**
     * Validates the dataset name.
     *
     * @param name The dataset name to validate.
     * @return The validated dataset name.
     */
    private String validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Dataset name cannot be null or empty");
        }
        return name;
    }

    /**
     * Validates the dataset headers.
     *
     * @param headers The dataset headers to validate.
     * @return The validated dataset headers.
     */
    private Set<Header> validateHeaders(Set<Header> headers) {
        if (headers == null || headers.isEmpty()) {
            throw new IllegalArgumentException("Dataset headers cannot be null or empty");
        }
        return headers;
    }

    /**
     * Validates the dataset rows.
     *
     * @param rows The dataset rows to validate.
     * @return The validated dataset rows.
     */
    private List<Row> validateRows(List<Row> rows) {
        if (rows == null || rows.isEmpty()) {
            throw new IllegalArgumentException("Dataset rows cannot be null or empty");
        }
        return rows;
    }

}
