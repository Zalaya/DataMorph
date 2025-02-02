package org.zalaya.datamorph.input;

import org.zalaya.datamorph.dataset.models.Dataset;
import org.zalaya.datamorph.dataset.models.Header;

import java.io.File;
import java.util.List;

public class CsvParser {

    private static final int MAX_SAMPLES = 10;

    private final String delimiter;

    public CsvParser(String delimiter) {
        this.delimiter = delimiter;
    }

    public Dataset parse(File file) {
        // TODO: Implement the logic to read the CSV file and return a Dataset object.
    }

    private Header parseHeader(List<String> cells) {
        // TODO: Using the inferHeaderType method, create a Header object from the list of cells corresponding to a column.
    }

    private List<Header> parseHeaders(List<String> lines) {
        // TODO: Using the parseHeader method, parse the first line of the CSV file and return a list of Header objects.
    }

    private Class<?> inferHeaderType(List<String> cells) {
        // TODO: Based on the list of cells, which correspond to a column, infer the data type of the header.
    }
}