package org.zalaya.dataset.enumerators;

import java.util.Date;

public enum HeaderType {

    NUMBER(Number.class),
    STRING(String.class),
    DATE(Date.class);

    private final Class<?> clazz;

    HeaderType(Class<?> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("HeaderType class cannot be null");
        }

        this.clazz = clazz;
    }

    public Class<?> getClazz() {
        return clazz;
    }

}
