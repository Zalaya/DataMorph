package org.zalaya.datamorph.dataset.enumerators;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.zalaya.datamorph.dataset.enumerators.HeaderType;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeaderTypeTest {

    @ParameterizedTest
    @EnumSource(HeaderType.class)
    void shouldReturnCorrectTypeForHeaderType(HeaderType type) {
        Class<?> expectedType = switch (type) {
            case NUMBER -> Number.class;
            case STRING -> String.class;
            case DATE -> LocalDate.class;
        };

        assertEquals(expectedType, type.getType());
    }

    @ParameterizedTest
    @EnumSource(HeaderType.class)
    void shouldSerializeAndDeserializeHeaderType(HeaderType type) {
        String serialized = type.name();
        HeaderType deserialized = HeaderType.valueOf(serialized);

        assertEquals(type, deserialized);
    }

}
