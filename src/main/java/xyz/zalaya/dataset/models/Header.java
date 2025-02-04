package xyz.zalaya.dataset.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import xyz.zalaya.dataset.enumerators.HeaderType;
import xyz.zalaya.dataset.exceptions.validation.HeaderValidationException;

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
     * @throws HeaderValidationException If the header name is null or empty.
     */
    private String validateName(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new HeaderValidationException("Header name must not be null or empty");
        }

        return name;
    }

    /**
     * Validates the header type.
     *
     * @param type The header type to validate.
     * @return The validated header type.
     */
    private HeaderType validateType(HeaderType type) {
        if (type == null) {
            throw new HeaderValidationException("Header type must not be null");
        }

        return type;
    }

}
