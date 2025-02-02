package org.zalaya.datamorph.input;

import org.zalaya.datamorph.dataset.models.Dataset;
import org.zalaya.datamorph.dataset.models.Header;
import org.zalaya.datamorph.dataset.models.Row;
import org.zalaya.datamorph.input.exceptions.CsvParsingException;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvParser {

    private static final int MAX_SAMPLES = 10;

    private final String delimiter;

    public CsvParser(String delimiter) {
        this.delimiter = delimiter;
    }

    public Dataset parse(File file) {
        List<String> lines = CsvReader.read(file);

        if (lines.isEmpty()) {
            throw new CsvParsingException("CSV file is empty: " + file.getAbsolutePath());
        }

        List<Header> headers = parseHeaders(lines.subList(0, Math.min(lines.size(), MAX_SAMPLES)));
        List<Row> rows = parseRows(headers, lines.subList(1, lines.size()));

        return new Dataset(file.getName(), headers, rows);
    }

    private List<Header> parseHeaders(List<String> lines) {
        String[] names = lines.get(0).split(delimiter);
        List<Header> headers = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            headers.add(parseHeader(names[i], lines, i));
        }

        return headers;
    }

    private Header parseHeader(String name, List<String> lines, int columnIndex) {
        List<String> samples = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String[] cells = lines.get(i).split(delimiter);

            if (cells.length > columnIndex) {
                samples.add(cells[columnIndex]);
            }
        }

        Class<?> type = CsvTypeInferer.inferType(samples);

        return new Header(name.trim(), CsvHeaderType.fromType(type));
    }

    private List<Row> parseRows(List<Header> headers, List<String> lines) {
        List<Row> rows = new ArrayList<>();

        for (String line : lines) {
            String[] cells = line.split(delimiter);

            if (cells.length != headers.size()) {
                throw new CsvParsingException("Row does not match header length");
            }

            rows.add(new Row(Arrays.asList(cells)));
        }

        return rows;
    }

}