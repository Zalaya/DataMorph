package xyz.zalaya.dataset.validation;

@FunctionalInterface
public interface Validator<T> {

    void validate(T input);

}
