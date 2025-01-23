package org.zalaya.dataset.models;

import org.zalaya.dataset.enumerators.HeaderType;

import java.util.Objects;

public record Header(String name, HeaderType type) {

    public Header {
        if (name == null || name.isBlank() || type == null) {
            throw new IllegalArgumentException("Header name and type must not be null or empty");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Header header)) {
            return false;
        }

        return Objects.equals(name, header.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}
