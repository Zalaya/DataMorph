package org.zalaya.dataset.exceptions.specific;

import org.zalaya.dataset.exceptions.generic.ModelValidationException;

public class InvalidDatasetException extends ModelValidationException {

    public InvalidDatasetException(String message) {
        super(message);
    }

}
