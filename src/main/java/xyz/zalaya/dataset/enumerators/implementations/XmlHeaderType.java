package xyz.zalaya.dataset.enumerators.implementations;

import xyz.zalaya.dataset.enumerators.HeaderType;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.time.LocalDateTime;

public enum XmlHeaderType implements HeaderType {

    STRING(String.class),
    INT(Integer.class),
    FLOAT(Float.class),
    DOUBLE(Double.class),
    DATE(LocalDate.class),
    DATETIME(LocalDateTime.class),
    DECIMAL(BigDecimal.class);

    private final Class<?> type;

    XmlHeaderType(Class<?> type) {
        this.type = type;
    }

    @Override
    public Class<?> getType() {
        return type;
    }

    public static XmlHeaderType fromType(Class<?> type) {
        return HeaderType.fromType(type, XmlHeaderType.values());
    }

}
