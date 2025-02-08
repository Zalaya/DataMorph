package xyz.zalaya.dataset.validation.header;

import xyz.zalaya.dataset.models.Header;
import xyz.zalaya.dataset.validation.Validator;

public class HeaderTypeValidator implements Validator<Header> {

    @Override
    public void validate(Header header) {
        if (header.getType() == null) {
            throw new IllegalArgumentException("Header type must not be null");
        }
    }

}
