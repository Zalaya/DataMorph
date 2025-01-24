package org.zalaya.dataset.builders;

import org.zalaya.dataset.enumerators.HeaderType;
import org.zalaya.dataset.models.Header;

public class HeaderBuilder {

    private String name;
    private HeaderType type;

    public HeaderBuilder name(String name) {
        this.name = name;
        return this;
    }

    public HeaderBuilder type(HeaderType type) {
        this.type = type;
        return this;
    }

    public Header build() {
        return new Header(name, type);
    }

}
