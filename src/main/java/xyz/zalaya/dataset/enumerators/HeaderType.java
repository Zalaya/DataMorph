package xyz.zalaya.dataset.enumerators;

import xyz.zalaya.dataset.exceptions.UnknownHeaderTypeException;

public interface HeaderType {

    Class<?> getType();

    default boolean isInstance(Object value) {
        return getType().isInstance(value);
    }

    static <T extends HeaderType> T fromType(Class<?> type, T[] values) {
        for (T value : values) {
            if (value.getType().isAssignableFrom(type)) {
                return value;
            }
        }

        throw new UnknownHeaderTypeException("No header type found for type: " + type);
    }

}
