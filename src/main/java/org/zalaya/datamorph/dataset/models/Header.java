package org.zalaya.datamorph.dataset.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import org.zalaya.datamorph.dataset.enumerators.HeaderType;
import org.zalaya.datamorph.dataset.exceptions.validation.HeaderValidationException;

@Getter
@Builder
@EqualsAndHashCode(exclude = "type")
public class Header {

    private final String name;
    private final HeaderType type;

    public Header(String name, HeaderType type) {
        if (name == null || name.trim().isBlank() || type == null) {
            throw new HeaderValidationException("Header name and type must not be null or empty");
        }

        this.name = name;
        this.type = type;
    }

}
