package org.zalaya.dataset.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import org.zalaya.dataset.enumerators.HeaderType;
import org.zalaya.dataset.exceptions.InvalidDatasetException;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DatasetTest {

    private Set<Header> headers;
    private List<Row> rows;

    @BeforeEach
    void setUp() {
        headers = Set.of(new Header("header", HeaderType.STRING));
        rows = List.of();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { " " })
    void shouldThrowExceptionWhenNameIsNullOrBlank(String name) {
        assertThrows(InvalidDatasetException.class, () -> {
            new Dataset(name, headers, rows);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowExceptionWhenHeadersAreNullOrEmpty(Set<Header> headers) {
        assertThrows(InvalidDatasetException.class, () -> {
            new Dataset("name", headers, rows);
        });
    }

    @Test
    void shouldReturnTrueWhenComparingDatasetsWithSameName() {
        String name = "name";
        Dataset dataset1 = new Dataset(name, headers, rows);
        Dataset dataset2 = new Dataset(name, headers, rows);

        assertEquals(dataset1, dataset2);
    }

    @Test
    void shouldReturnFalseWhenComparingDatasetsWithDifferentName() {
        String name1 = "name1";
        String name2 = "name2";
        Dataset dataset1 = new Dataset(name1, headers, rows);
        Dataset dataset2 = new Dataset(name2, headers, rows);

        assertNotEquals(dataset1, dataset2);
    }

}