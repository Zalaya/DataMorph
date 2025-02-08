package xyz.zalaya.dataset.validation.header;

import xyz.zalaya.dataset.models.Header;
import xyz.zalaya.dataset.validation.Validator;

public class HeaderNameValidator implements Validator<Header> {

    @Override
    public void validate(Header header) {
        if (header.getName() == null || header.getName().trim().isBlank()) {
            throw new IllegalArgumentException("Header name must not be null or empty");
        }
    }

}
