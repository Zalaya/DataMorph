package org.zalaya.datamorph.input;

import org.zalaya.datamorph.input.exceptions.CsvReadingException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<String> read(File file) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new CsvReadingException("Failed to read CSV file: " + file.getAbsolutePath(), e);
        }

        return lines;
    }

}
