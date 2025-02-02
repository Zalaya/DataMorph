package xyz.zalaya.dataset.enumerators.implementations;

import xyz.zalaya.dataset.enumerators.HeaderType;

public enum JsonHeaderType implements HeaderType {

    STRING(String.class),
    NUMBER(Number.class),
    BOOLEAN(Boolean.class),
    ARRAY(Object[].class),
    OBJECT(Object.class),
    NULL(null);

    private final Class<?> type;

    JsonHeaderType(Class<?> type) {
        this.type = type;
    }

    @Override
    public Class<?> getType() {
        return type;
    }

    public static JsonHeaderType fromType(Class<?> type) {
        return HeaderType.fromType(type, JsonHeaderType.values());
    }

}
