package xyz.zalaya.dataset.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import xyz.zalaya.dataset.enumerators.HeaderType;

@Getter
@EqualsAndHashCode(exclude = {"type"})
public class Header {

    private final String name;
    private final HeaderType type;

    public Header(String name, HeaderType type) {
        this.name = validateName(name);
        this.type = validateType(type);
    }

    private String validateName(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException("Header name must not be null or empty");
        }

        return name;
    }

    private HeaderType validateType(HeaderType type) {
        if (type == null) {
            throw new IllegalArgumentException("Header type must not be null");
        }

        return type;
    }

}
