package org.zalaya.dataset.models;

import org.zalaya.dataset.enumerators.HeaderType;
import org.zalaya.dataset.exceptions.InvalidHeaderException;

public class HeaderBuilder {

    private String name;
    private HeaderType type;

    public HeaderBuilder name(String name) {
        this.name = name;
        return this;
    }

    public HeaderBuilder type(HeaderType type) {
        this.type = type;
        return this;
    }

    public Header build() {
        if (name == null || name.isBlank() || type == null) {
            throw new InvalidHeaderException("Header name and type must not be null or empty");
        }

        return new Header(name, type);
    }

}
