package org.zalaya.dataset.models;

import org.junit.jupiter.api.Test;
import org.zalaya.dataset.enumerators.HeaderType;
import org.zalaya.dataset.exceptions.InvalidDatasetException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

}
