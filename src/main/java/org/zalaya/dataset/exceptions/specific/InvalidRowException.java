package org.zalaya.dataset.exceptions.specific;

import org.zalaya.dataset.exceptions.generic.ModelValidationException;

public class InvalidRowException extends ModelValidationException {

    public InvalidRowException(String message) {
        super(message);
    }

}
