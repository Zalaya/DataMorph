package org.zalaya.dataset.exceptions.specific;

import org.zalaya.dataset.exceptions.generic.ModelValidationException;

public class InvalidCellException extends ModelValidationException {

    public InvalidCellException(String message) {
        super(message);
    }

}
