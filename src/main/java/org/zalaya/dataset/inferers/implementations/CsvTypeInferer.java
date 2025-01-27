package org.zalaya.dataset.inferers.implementations;

import org.zalaya.dataset.enumerators.CsvHeaderType;
import org.zalaya.dataset.inferers.AbstractTypeInferer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class CsvTypeInferer extends AbstractTypeInferer<CsvHeaderType> {

    private static final List<DateTimeFormatter> DATE_FORMATS = List.of(
        DateTimeFormatter.ofPattern("yyyy-MM-dd"),
        DateTimeFormatter.ofPattern("dd-MM-yyyy"),
        DateTimeFormatter.ofPattern("yyyy/MM/dd"),
        DateTimeFormatter.ofPattern("dd/MM/yyyy")
    );

    private static final Map<CsvHeaderType, Predicate<String>> VALIDATORS = Map.of(
        CsvHeaderType.NUMBER, CsvTypeInferer::isNumber,
        CsvHeaderType.STRING, value -> true,
        CsvHeaderType.DATE, CsvTypeInferer::isDate
    );

    @Override
    public CsvHeaderType infer(List<String> values) {
        List<String> samples = getSampleValues(values);

        for (CsvHeaderType type : CsvHeaderType.values()) {
            if (samples.stream().allMatch(VALIDATORS.get(type))) {
                return type;
            }
        }

        return CsvHeaderType.STRING;
    }

    private static boolean isNumber(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDate(String value) {
        for (DateTimeFormatter format : DATE_FORMATS) {
            try {
                LocalDate.parse(value, format);
                return true;
            } catch (Exception ignored) {
                // Continue to the next format
            }
        }

        return false;
    }

}
