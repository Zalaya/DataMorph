package xyz.zalaya.dataset.enumerators;

import xyz.zalaya.dataset.exceptions.UnknownHeaderTypeException;
import xyz.zalaya.dataset.exceptions.validation.HeaderTypeValidationException;

public interface HeaderType {

    Class<?> getType();

    static <T extends HeaderType> T fromType(Class<?> type, T[] values) {
        if (type == null || values == null) {
            throw new HeaderTypeValidationException("Type and values cannot be null");
        }

        for (T value : values) {
            if (value.getType().isAssignableFrom(type)) {
                return value;
            }
        }

        throw new UnknownHeaderTypeException("No header type found for type: " + type);
    }

}
