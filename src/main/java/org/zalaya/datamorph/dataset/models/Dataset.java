package org.zalaya.datamorph.dataset.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import org.zalaya.datamorph.dataset.exceptions.validation.DatasetValidationException;

import java.util.HashSet;
import java.util.List;

@Getter
@Builder
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
     */
    private String validateName(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new DatasetValidationException("Dataset name must not be null or empty");
        }

        return name;
    }

    /**
     * Validates the dataset headers.
     *
     * @param headers The dataset headers to validate.
     * @return The validated dataset headers.
     */
    private List<Header> validateHeaders(List<Header> headers) {
        if (headers == null || headers.isEmpty()) {
            throw new DatasetValidationException("Dataset headers must not be null");
        }

        if (new HashSet<>(headers).size() != headers.size()) {
            throw new DatasetValidationException("Dataset can't have two duplicate headers");
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
        if (rows != null && !rows.isEmpty()) {
            for (Row row : rows) {
                validateRow(row);
            }
        }

        return rows;
    }

    /**
     * Validates the dataset row.
     *
     * @param row The dataset row to validate.
     */
    private void validateRow(Row row) {
        if (row.getCells().size() != headers.size()) {
            throw new DatasetValidationException("Dataset row must have the same number of cells as the number of headers");
        }

        for (int i = 0; i < headers.size(); i++) {
            if (!headers.get(i).getType().isValidType(row.getCells().get(i))) {
                throw new DatasetValidationException("Dataset row cell must be of the same type as the header type");
            }
        }

    }

}
