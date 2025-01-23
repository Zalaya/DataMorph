package org.zalaya.dataset.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import org.zalaya.dataset.enumerators.HeaderType;

@Builder
@EqualsAndHashCode(exclude = {"type"})
public record Header(String name, HeaderType type) {

    public Header {
        if (name == null || name.isBlank() || type == null) {
            throw new IllegalArgumentException("Header name and type must not be null or empty");
        }
    }

}
