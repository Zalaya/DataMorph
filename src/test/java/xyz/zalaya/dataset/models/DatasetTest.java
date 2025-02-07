package xyz.zalaya.dataset.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import xyz.zalaya.dataset.mocks.MockHeaderType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatasetTest {

    private List<Header> headers;
    private List<Row> rows;

    @BeforeEach
    void setUp() {
        headers = List.of(
            new Header("header1", MockHeaderType.STRING),
            new Header("header2", MockHeaderType.INTEGER),
            new Header("header3", MockHeaderType.BOOLEAN)
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
        assertThrows(IllegalArgumentException.class, () -> {
            new Dataset(name, headers, rows);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowExceptionWhenHeadersAreNullOrEmpty(List<Header> headers) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Dataset("dataset", headers, rows);
        });
    }

    @Test
    void shouldThrowExceptionWhenHeadersContainDuplicates() {
        headers = List.of(
            new Header("header1", MockHeaderType.STRING),
            new Header("header1", MockHeaderType.INTEGER),
            new Header("header3", MockHeaderType.BOOLEAN)
        );

        assertThrows(IllegalArgumentException.class, () -> {
            new Dataset("dataset", headers, rows);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowExceptionWhenRowsAreNullOrEmpty(List<Row> rows) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Dataset("dataset", headers, rows);
        });
    }

    @Test
    void shouldReturnTrueWhenComparingTwoDatasetsWithSameName() {
        Dataset dataset1 = new Dataset("dataset", headers, rows);
        Dataset dataset2 = new Dataset("dataset", headers, rows);

        assertEquals(dataset1, dataset2);
    }

    @Test
    void shouldReturnFalseWhenComparingTwoDatasetsWithDifferentName() {
        Dataset dataset1 = new Dataset("dataset1", headers, rows);
        Dataset dataset2 = new Dataset("dataset2", headers, rows);

        assertNotEquals(dataset1, dataset2);
    }

}
