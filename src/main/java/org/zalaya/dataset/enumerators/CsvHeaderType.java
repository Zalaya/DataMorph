package org.zalaya.dataset.enumerators;

import java.time.LocalDate;

public enum CsvHeaderType implements HeaderType {

    NUMBER(Number.class),
    STRING(String.class),
    DATE(LocalDate.class);

    private final Class<?> type;

    CsvHeaderType(Class<?> type) {
        this.type = type;
    }

    @Override
    public Class<?> getType() {
        return type;
    }

}
