package org.zalaya.datamorph.dataset.enumerators;

public interface HeaderType {

    Class<?> getType();

    default boolean isValidType(Object value) {
        return getType().isInstance(value);
    }

}
