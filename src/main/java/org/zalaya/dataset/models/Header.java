package org.zalaya.dataset.models;

import org.zalaya.dataset.enumerators.HeaderType;

public class Header {

    private final String name;
    private final HeaderType type;

    public Header(String name, HeaderType type) {
        if (name == null || name.isBlank() || type == null) {
            throw new IllegalArgumentException("Header name and type cannot be null or blank");
        }

        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public HeaderType getType() {
        return type;
    }

}
