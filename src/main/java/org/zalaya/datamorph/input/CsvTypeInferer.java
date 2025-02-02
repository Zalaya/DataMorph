package org.zalaya.datamorph.input;

import java.util.List;

public class CsvTypeInferer {

    public static Class<?> inferType(List<String> samples) {
        if (allMatch(samples, CsvTypeInferer::isNumber)) {
            return Number.class;
        }

        if (allMatch(samples, CsvTypeInferer::isBoolean)) {
            return Boolean.class;
        }

        return String.class;
    }

    private static boolean allMatch(List<String> samples, TypeChecker checker) {
        return samples.stream().allMatch(checker::check);
    }

    private static boolean isNumber(String sample) {
        return sample.matches("-?\\d+(\\.\\d+)?");
    }

    private static boolean isBoolean(String sample) {
        return sample.equalsIgnoreCase("true") || sample.equalsIgnoreCase("false");
    }

    @FunctionalInterface
    private interface TypeChecker {
        boolean check(String sample);
    }

}
