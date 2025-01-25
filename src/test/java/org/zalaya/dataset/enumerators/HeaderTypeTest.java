package org.zalaya.dataset.enumerators;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeaderTypeTest {

    @ParameterizedTest
    @EnumSource(HeaderType.class)
    void shouldReturnCorrectTypeForEachHeaderType(HeaderType type) {
        Class<?> expectedType = switch (type) {
            case NUMBER -> Number.class;
            case STRING -> String.class;
            case DATE -> LocalDate.class;
        };

        assertEquals(expectedType, type.getType());
    }

}
