package org.zalaya.dataset.enumerators;

import java.time.LocalDate;

public enum HeaderType {

    NUMBER(Number.class),
    STRING(String.class),
    DATE(LocalDate.class);

    private final Class<?> type;

    HeaderType(Class<?> type) {
        this.type = type;
    }

    public Class<?> getType() {
        return type;
    }

}
