package org.zalaya.dataset.enumerators;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvHeaderTypeTest {

    @ParameterizedTest
    @EnumSource(CsvHeaderType.class)
    void shouldReturnCorrectTypeForHeaderType(CsvHeaderType type) {
        Class<?> expectedType = switch (type) {
            case NUMBER -> Number.class;
            case STRING -> String.class;
            case DATE -> LocalDate.class;
        };

        assertEquals(expectedType, type.getType());
    }

    @ParameterizedTest
    @EnumSource(CsvHeaderType.class)
    void shouldSerializeAndDeserializeHeaderType(CsvHeaderType type) {
        String serialized = type.name();
        CsvHeaderType deserialized = CsvHeaderType.valueOf(serialized);

        assertEquals(type, deserialized);
    }

}
