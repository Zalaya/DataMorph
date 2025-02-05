package xyz.zalaya.dataset.mocks;

import xyz.zalaya.dataset.enumerators.HeaderType;

public enum MockHeaderType implements HeaderType {

    STRING(String.class),
    INTEGER(Integer.class),
    BOOLEAN(Boolean.class);

    private final Class<?> type;

    MockHeaderType(Class<?> type) {
        this.type = type;
    }

    @Override
    public Class<?> getType() {
        return type;
    }

}
