package xyz.zalaya.dataset.enumerators;

public interface HeaderType {

    Class<?> getType();

    static <T extends HeaderType> T fromType(Class<?> type, T[] values) {
        if (type == null || values == null || values.length == 0) {
            throw new IllegalArgumentException("Type and values must not be null or empty");
        }

        for (T value : values) {
            if (value.getType().isAssignableFrom(type)) {
                return value;
            }
        }

        throw new IllegalArgumentException("No header type found for type: " + type);
    }

}
