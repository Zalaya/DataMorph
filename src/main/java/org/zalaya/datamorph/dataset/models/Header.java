package org.zalaya.datamorph.dataset.models;

import org.zalaya.datamorph.dataset.annotations.Entity;
import org.zalaya.datamorph.dataset.enumerators.HeaderType;
import org.zalaya.datamorph.dataset.exceptions.HeaderValidationException;

import java.util.Objects;

@Entity
public record Header(String name, HeaderType type) {

    public Header {
        if (name == null || name.isBlank() || type == null) {
            throw new HeaderValidationException("Header name and type must not be null or empty");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Header header)) {
            return false;
        }

        return Objects.equals(name, header.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}
