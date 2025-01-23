package org.zalaya.dataset.models;

import org.zalaya.dataset.enumerators.HeaderType;
import org.zalaya.dataset.exceptions.InvalidHeaderException;

public record Header(String name, HeaderType type) {

    public Header {
        if (name == null || name.isBlank() || type == null) {
            throw new InvalidHeaderException("Header name and type must not be null or empty");
        }
    }

    public static HeaderBuilder builder() {
        return new HeaderBuilder();
    }

}
