package org.zalaya.datamorph.dataset.models;

import org.zalaya.datamorph.dataset.enumerators.HeaderType;

import java.util.Objects;

public class Header {

    private final String name;
    private final HeaderType type;

    public Header(String name, HeaderType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public HeaderType getType() {
        return type;
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
