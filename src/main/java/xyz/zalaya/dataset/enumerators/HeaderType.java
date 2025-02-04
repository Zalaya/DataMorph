package xyz.zalaya.dataset.enumerators;

import xyz.zalaya.dataset.exceptions.UnknownHeaderTypeException;

public interface HeaderType {

    Class<?> getType();

    static <T extends HeaderType> T fromType(Class<?> type, T[] values) {
        for (T value : values) {
            if (value.getType().isAssignableFrom(type)) {
                return value;
            }
        }

        throw new UnknownHeaderTypeException("No header type found for type: " + type);
    }

}
