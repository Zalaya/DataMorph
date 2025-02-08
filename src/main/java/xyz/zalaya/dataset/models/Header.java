package xyz.zalaya.dataset.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import xyz.zalaya.dataset.enumerators.HeaderType;
import xyz.zalaya.dataset.validation.header.HeaderNameValidator;
import xyz.zalaya.dataset.validation.header.HeaderTypeValidator;
import xyz.zalaya.dataset.validation.ValidationChain;

@Getter
@EqualsAndHashCode(exclude = {"type"})
public class Header {

    private final String name;
    private final HeaderType type;

    public Header(String name, HeaderType type) {
        new ValidationChain<Header>()
            .add(new HeaderNameValidator())
            .add(new HeaderTypeValidator())
            .validate(this);

        this.name = name;
        this.type = type;
    }

}
