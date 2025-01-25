package org.zalaya.dataset.models;

import org.junit.jupiter.api.Test;

import org.zalaya.dataset.enumerators.HeaderType;
import org.zalaya.dataset.exceptions.InvalidDatasetException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DatasetTest {

    @Test
    void shouldThrowExceptionWhenHeadersAreNull() {
        Set<Header> headers = null;
        Row row = new Row(new LinkedHashMap<>(Map.of(new Header("header1", HeaderType.STRING), "value1")));
        List<Row> rows = List.of(row);

        assertThrows(InvalidDatasetException.class, () -> {
            new Dataset(headers, rows);
        });
    }

    @Test
    void shouldThrowExceptionWhenRowsAreNull() {
        Set<Header> headers = Set.of(new Header("header1", HeaderType.STRING));
        List<Row> rows = null;

        assertThrows(InvalidDatasetException.class, () -> {
            new Dataset(headers, rows);
        });
    }

    @Test
    void shouldInstantiateWithEmptyHeaders() {
        Row row = new Row(new LinkedHashMap<>(Map.of(new Header("header", HeaderType.STRING), "value")));
        Set<Header> headers = Set.of();
        List<Row> rows = List.of(row);
        Dataset dataset = Dataset.withEmptyHeaders(List.of(row));

        assertEquals(new Dataset(headers, rows), dataset);
    }

    @Test
    void shouldInstantiateWithEmptyRows() {
        Header header = new Header("header", HeaderType.STRING);
        Dataset dataset = Dataset.withEmptyRows(Set.of(header));
        Set<Header> headers = Set.of(header);
        List<Row> rows = List.of();

        assertEquals(new Dataset(headers, rows), dataset);
    }

}
