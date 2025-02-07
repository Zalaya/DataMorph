package xyz.zalaya.dataset.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashSet;
import java.util.List;

@Getter
@EqualsAndHashCode(exclude = {"headers", "rows"})
public class Dataset {

    private final String name;
    private final List<Header> headers;
    private final List<Row> rows;

    public Dataset(String name, List<Header> headers, List<Row> rows) {
        this.name = validateName(name);
        this.headers = validateHeaders(headers);
        this.rows = validateRows(rows);
    }

    /**
     * Validates the dataset name.
     *
     * @param name The dataset name to validate.
     * @return The validated dataset name.
     * @throws IllegalArgumentException If the dataset name is null or empty.
     */
    private String validateName(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException("Dataset name must not be null or empty");
        }

        return name;
    }

    /**
     * Validates the dataset headers.
     *
     * @param headers The dataset headers to validate.
     * @return The validated dataset headers.
     * @throws IllegalArgumentException If the dataset headers are null or contain duplicates.
     */
    private List<Header> validateHeaders(List<Header> headers) {
        if (headers == null || headers.isEmpty()) {
            throw new IllegalArgumentException("Dataset headers must not be null or empty");
        }

        if (new HashSet<>(headers).size() != headers.size()) {
            throw new IllegalArgumentException("Dataset headers must not contain duplicates");
        }

        return headers;
    }

    /**
     * Validates the dataset rows.
     *
     * @param rows The dataset rows to validate.
     * @return The validated dataset rows.
     * @throws IllegalArgumentException If the dataset rows are null or empty.
     */
    private List<Row> validateRows(List<Row> rows) {
        if (rows == null || rows.isEmpty()) {
            throw new IllegalArgumentException("Dataset rows must not be null or empty");
        }

        return rows;
    }

}
