package xyz.zalaya.dataset.enumerators.implementations;

import xyz.zalaya.dataset.enumerators.HeaderType;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public enum SqlHeaderType implements HeaderType {

    INT(Integer.class),
    BIGINT(Long.class),
    DECIMAL(BigDecimal.class),
    DOUBLE(Double.class),
    VARCHAR(String.class),
    BOOLEAN(Boolean.class),
    DATE(LocalDate.class),
    TIME(LocalTime.class),
    TIMESTAMP(LocalDateTime.class);

    private final Class<?> type;

    SqlHeaderType(Class<?> type) {
        this.type = type;
    }

    @Override
    public Class<?> getType() {
        return type;
    }

    public static SqlHeaderType fromType(Class<?> type) {
        return HeaderType.fromType(type, SqlHeaderType.values());
    }

}
