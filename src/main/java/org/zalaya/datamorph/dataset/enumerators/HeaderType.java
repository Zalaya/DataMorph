package org.zalaya.datamorph.dataset.enumerators;

public interface HeaderType {

    Class<?> getType();

    default boolean isInstance(Object value) {
        return getType().isInstance(value);
    }

}
