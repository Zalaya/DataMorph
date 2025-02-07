package xyz.zalaya.dataset.enumerators;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import xyz.zalaya.dataset.mocks.MockHeaderType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HeaderTypeTest {

    @Test
    void shouldReturnTypeWhenGetTypeIsCalled() {
        HeaderType type = MockHeaderType.STRING;

        assertEquals(String.class, type.getType());
    }

    @Test
    void shouldReturnCorrectHeaderTypeWhenFromTypeIsCalled() {
        MockHeaderType[] values = MockHeaderType.values();
        HeaderType type = HeaderType.fromType(String.class,values);

        assertEquals(MockHeaderType.STRING, type);
    }

    @Test
    void shouldThrowExceptionWhenFromTypeIsCalledWithUnknownType() {
        MockHeaderType[] values = MockHeaderType.values();

        assertThrows(IllegalArgumentException.class, () -> {
            HeaderType.fromType(Double.class, values);
        });
    }

    @Test
    void shouldThrowExceptionWhenFromTypeIsCalledWithNullType() {
        Class<?> type = null;
        MockHeaderType[] values = MockHeaderType.values();

        assertThrows(IllegalArgumentException.class, () -> {
            HeaderType.fromType(type, values);
        });
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowExceptionWhenFromTypeIsCalledWithNullValues(MockHeaderType[] values) {
        assertThrows(IllegalArgumentException.class, () -> {
            HeaderType.fromType(String.class, values);
        });
    }

}
