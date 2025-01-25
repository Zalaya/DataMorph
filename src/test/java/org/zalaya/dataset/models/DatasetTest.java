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

public class DatasetTest {

    @Test
    public void shouldThrowExceptionWhenHeadersAreNull() {
        Set<Header> headers = null;
        Row row = new Row(new LinkedHashMap<>(Map.of(new Header("header1", HeaderType.STRING), "value1")));

        assertThrows(InvalidDatasetException.class, () -> {
            new Dataset(headers, List.of(row));
        });
    }

    @Test
    public void shouldThrowExceptionWhenRowsAreNull() {
        Set<Header> headers = Set.of(new Header("header1", HeaderType.STRING));
        List<Row> rows = null;

        assertThrows(InvalidDatasetException.class, () -> {
            new Dataset(headers, rows);
        });
    }

    @Test
    public void shouldInstantiateWithEmptyHeaders() {
        Row row = new Row(new LinkedHashMap<>(Map.of(new Header("header", HeaderType.STRING), "value")));
        Dataset dataset = Dataset.withEmptyHeaders(List.of(row));

        assertEquals(new Dataset(Set.of(), List.of(row)), dataset);
    }

    @Test
    public void shouldInstantiateWithEmptyRows() {
        Header header = new Header("header", HeaderType.STRING);
        Dataset dataset = Dataset.withEmptyRows(Set.of(header));

        assertEquals(new Dataset(Set.of(header), List.of()), dataset);
    }

}
