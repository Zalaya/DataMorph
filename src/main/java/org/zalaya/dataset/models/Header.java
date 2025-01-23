package org.zalaya.dataset.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import org.zalaya.dataset.enumerators.HeaderType;
import org.zalaya.dataset.exceptions.InvalidHeaderException;

@Getter
@Builder
@EqualsAndHashCode(exclude = {"type"})
public class Header {

    private final String name;
    private final HeaderType type;

    public Header(String name, HeaderType type) {
        if (name == null || name.isBlank() || type == null) {
            throw new InvalidHeaderException("Header name and type must not be null or empty");
        }

        this.name = name;
        this.type = type;
    }

}