package org.zalaya.datamorph.dataset.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import org.zalaya.datamorph.dataset.exceptions.validation.DatasetValidationException;

import java.util.*;

@Getter
@EqualsAndHashCode(exclude = {"headers", "rows"})
public class Dataset {

    private final String name;
    private final List<Header> headers;
    private final List<Row> rows;

    // TODO: Validate that the rows of the Dataset have the same number of cells as the number of headers.
    // TODO: Validate that the cells of the rows of the Dataset are of the same type as the headers.

    public Dataset(String name, List<Header> headers, List<Row> rows) {
        this.name = validateName(name);
        this.headers = new ArrayList<>(validateHeaders(headers));
        this.rows = new ArrayList<>(rows);
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
            throw new DatasetValidationException("Dataset headers must not be null or empty");
        }

        if (new HashSet<>(headers).size() != headers.size()) {
            throw new DatasetValidationException("Dataset headers must not contain duplicates");
        }

        return new ArrayList<>(headers);
    }

}
