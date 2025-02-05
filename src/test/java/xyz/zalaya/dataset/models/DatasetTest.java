package xyz.zalaya.dataset.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import xyz.zalaya.dataset.exceptions.validation.DatasetValidationException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static xyz.zalaya.dataset.utilities.MockUtilities.mockHeaderType;

class DatasetTest {

    private List<Header> headers;
    private List<Row> rows;

    @BeforeEach
    void setUp() {
        headers = List.of(
            new Header("header1", mockHeaderType(String.class)),
            new Header("header2", mockHeaderType(Integer.class)),
            new Header("header3", mockHeaderType(Boolean.class))
        );

        rows = List.of(
            new Row(headers, List.of("cell1", 1, true)),
            new Row(headers, List.of("cell2", 2, false)),
            new Row(headers, List.of("cell3", 3, true))
        );
    }

    @Test
    void shouldCreateDatasetWithValidAttributes() {
        String name = "dataset";
        Dataset dataset = new Dataset(name, headers, rows);

        assertEquals(name, dataset.getName());
        assertEquals(headers, dataset.getHeaders());
        assertEquals(rows, dataset.getRows());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowExceptionWhenNameIsNullOrBlank(String name) {
        assertThrows(DatasetValidationException.class, () -> {
            new Dataset(name, headers, rows);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowExceptionWhenHeadersAreNullOrEmpty(List<Header> headers) {
        assertThrows(DatasetValidationException.class, () -> {
            new Dataset("dataset", headers, rows);
        });
    }

    @Test
    void shouldThrowExceptionWhenHeadersContainDuplicates() {
        headers = List.of(
            new Header("header1", mockHeaderType(String.class)),
            new Header("header1", mockHeaderType(Integer.class)),
            new Header("header3", mockHeaderType(Boolean.class))
        );

        assertThrows(DatasetValidationException.class, () -> {
            new Dataset("dataset", headers, rows);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowExceptionWhenRowsAreNullOrEmpty(List<Row> rows) {
        assertThrows(DatasetValidationException.class, () -> {
            new Dataset("dataset", headers, rows);
        });
    }

}
