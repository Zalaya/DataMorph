package xyz.zalaya.dataset.enumerators;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import xyz.zalaya.dataset.exceptions.UnknownHeaderTypeException;
import xyz.zalaya.dataset.exceptions.validation.HeaderTypeValidationException;
import xyz.zalaya.dataset.mocks.MockHeaderType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HeaderTypeTest {

    @Test
    void shouldReturnCorrectHeaderTypeWhenFromTypeIsCalled() {
        MockHeaderType[] values = MockHeaderType.values();
        HeaderType type = HeaderType.fromType(String.class,values);

        assertEquals(MockHeaderType.STRING, type);
    }

    @Test
    void shouldThrowExceptionWhenFromTypeIsCalledWithUnknownType() {
        MockHeaderType[] values = MockHeaderType.values();

        assertThrows(UnknownHeaderTypeException.class, () -> {
            HeaderType.fromType(Double.class, values);
        });
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowExceptionWhenFromTypeIsCalledWithNullType(Class<?> type) {
        MockHeaderType[] values = MockHeaderType.values();

        assertThrows(HeaderTypeValidationException.class, () -> {
            HeaderType.fromType(type, values);
        });
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowExceptionWhenFromTypeIsCalledWithNullValues(MockHeaderType[] values) {
        assertThrows(HeaderTypeValidationException.class, () -> {
            HeaderType.fromType(String.class, values);
        });
    }

}
