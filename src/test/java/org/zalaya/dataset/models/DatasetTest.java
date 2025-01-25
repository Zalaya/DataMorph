package org.zalaya.dataset.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import org.zalaya.dataset.enumerators.HeaderType;
import org.zalaya.dataset.exceptions.specific.InvalidDatasetException;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DatasetTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { " " })
    void shouldThrowExceptionWhenNameIsNullOrBlank(String name) {
        Set<Header> headers = Set.of(new Header("header", HeaderType.STRING));
        List<Row> rows = List.of();

        assertThrows(InvalidDatasetException.class, () -> {
            new Dataset(name, headers, rows);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowExceptionWhenHeadersAreNullOrEmpty(Set<Header> headers) {
        List<Row> rows = List.of();

        assertThrows(InvalidDatasetException.class, () -> {
            new Dataset("name", headers, rows);
        });
    }

    @Test
    void shouldReturnTrueWhenComparingDatasetsWithSameValues() {
        String name = "name";
        Set<Header> headers = Set.of(new Header("header", HeaderType.STRING));
        List<Row> rows = List.of();

        Dataset dataset1 = new Dataset(name, headers, rows);
        Dataset dataset2 = new Dataset(name, headers, rows);

        assertEquals(dataset1, dataset2);
    }

    @Test
    void shouldReturnFalseWhenComparingDatasetsWithDifferentValues() {
        String name1 = "name1";
        String name2 = "name2";
        Set<Header> headers = Set.of(new Header("header", HeaderType.STRING));
        List<Row> rows = List.of();

        Dataset dataset1 = new Dataset(name1, headers, rows);
        Dataset dataset2 = new Dataset(name2, headers, rows);

        assertNotEquals(dataset1, dataset2);
    }

}
