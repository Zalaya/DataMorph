package xyz.zalaya.dataset.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationChain<T> {

    private final List<Validator<T>> validators = new ArrayList<>();

    public ValidationChain<T> add(Validator<T> validator) {
        validators.add(validator);
        return this;
    }

    public void validate(T input) {
        for (Validator<T> validator : validators) {
            validator.validate(input);
        }
    }

}
