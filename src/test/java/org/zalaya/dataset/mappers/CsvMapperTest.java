package org.zalaya.dataset.mappers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.zalaya.dataset.exceptions.CsvMappingException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvMapperTest {

    private static final String DELIMITER = ";";

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" "})
    void shouldThrowExceptionWhenDelimiterIsNull(String delimiter) {
        assertThrows(IllegalArgumentException.class, () -> {
            new CsvMapper(delimiter);
        });
    }

    @Test
    void shouldThrowExceptionWhenFileDoesNotExist() {
        String filePath = "nonexistent.csv";
        CsvMapper mapper = new CsvMapper(DELIMITER);

        assertThrows(CsvMappingException.class, () -> {
            mapper.map(filePath);
        });
    }

    @Test
    void shouldNotThrowExceptionWhenFileExists() {
        String filePath = "src/test/resources/fixtures/mixed_fixture.csv";
        CsvMapper mapper = new CsvMapper(DELIMITER);

        assertDoesNotThrow(() -> {
            mapper.map(filePath);
        });
    }

    @Test
    void shouldMapCsvFile() {
        String filePath = "src/test/resources/fixtures/mixed_fixture.csv";
        List<List<String>> result = new CsvMapper(DELIMITER).map(filePath);

        assertEquals("Jane Smith", result.get(2).get(1));
        assertEquals("2023-12-31", result.get(3).get(2));
    }

}
