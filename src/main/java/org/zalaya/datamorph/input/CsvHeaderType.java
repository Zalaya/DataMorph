package org.zalaya.datamorph.input;

import org.zalaya.datamorph.dataset.enumerators.HeaderType;

public enum CsvHeaderType implements HeaderType {

    NUMBER(Number.class),
    BOOLEAN(Boolean.class),
    STRING(String.class);

    private final Class<?> type;

    CsvHeaderType(Class<?> type) {
        this.type = type;
    }

    @Override
    public Class<?> getType() {
        return type;
    }

    public static CsvHeaderType fromType(Class<?> type) {
        for (CsvHeaderType headerType: values()) {
            if (headerType.getType().equals(type)) {
                return headerType;
            }
        }

        throw new IllegalArgumentException("Unknown header type: " + type);
    }

}
