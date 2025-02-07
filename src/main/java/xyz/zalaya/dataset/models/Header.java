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

    /**
     * Validates the header name.
     *
     * @param name The header name to validate.
     * @return The validated header name.
     * @throws IllegalArgumentException If the header name is null or empty.
     */
    private String validateName(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException("Header name must not be null or empty");
        }

        return name;
    }

    /**
     * Validates the header type.
     *
     * @param type The header type to validate.
     * @return The validated header type.
     * @throws IllegalArgumentException If the header type is null.
     */
    private HeaderType validateType(HeaderType type) {
        if (type == null) {
            throw new IllegalArgumentException("Header type must not be null");
        }

        return type;
    }

}
