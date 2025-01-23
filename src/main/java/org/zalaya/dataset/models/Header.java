package org.zalaya.dataset.models;

import lombok.Builder;

import org.zalaya.dataset.enumerators.HeaderType;

@Builder
public record Header(String name, HeaderType type) {

    public Header {
        if (name == null || name.isBlank() || type == null) {
            throw new IllegalArgumentException("Header name and type must not be null or empty");
        }
    }

}
