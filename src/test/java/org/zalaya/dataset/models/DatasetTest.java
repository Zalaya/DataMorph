package org.zalaya.dataset.models;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import org.zalaya.dataset.enumerators.HeaderType;
import org.zalaya.dataset.exceptions.InvalidDatasetException;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

class DatasetTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" "})
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
        String name = "dataset";
        List<Row> rows = List.of();

        assertThrows(InvalidDatasetException.class, () -> {
            new Dataset(name, headers, rows);
        });
    }

}