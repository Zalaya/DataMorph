package org.zalaya.dataset.inferers;

import org.zalaya.dataset.enumerators.HeaderType;

import java.util.List;

public abstract class AbstractTypeInferer<T extends HeaderType> implements TypeInferer<T> {

    protected static final int MAX_SAMPLES = 10;

    protected List<String> getSampleValues(List<String> columnValues) {
        return columnValues.stream()
            .filter(value -> value != null && !value.isBlank())
            .limit(MAX_SAMPLES)
            .toList();
    }

}
