package org.zalaya.dataset.mappers;

import org.zalaya.dataset.exceptions.CsvMappingException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvMapper {

    private final String delimiter;

    public CsvMapper(String delimiter) {
        if (delimiter == null || delimiter.isBlank()) {
            throw new IllegalArgumentException("Delimiter must not be null or empty");
        }

        this.delimiter = delimiter;
    }

    public List<List<String>> map(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines()
                .map(line -> List.of(line.split(delimiter)))
                .toList();
        } catch (IOException e) {
            throw new CsvMappingException("Failed to map CSV file");
        }
    }

}
