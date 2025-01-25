package org.zalaya.dataset.exceptions.specific;

import org.zalaya.dataset.exceptions.generic.ModelValidationException;

public class InvalidHeaderException extends ModelValidationException {

    public InvalidHeaderException(String message) {
        super(message);
    }

}
