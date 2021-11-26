package io.knowit.backend.exception;

import org.springframework.validation.Errors;

public class BodyValidationException extends RuntimeException {
    private Errors errors;

    public BodyValidationException(Errors errors) {
        this.errors = errors;
    }

    public BodyValidationException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public BodyValidationException(String message, Throwable cause, Errors errors) {
        super(message, cause);
        this.errors = errors;
    }

    public BodyValidationException(Throwable cause, Errors errors) {
        super(cause);
        this.errors = errors;
    }

    public BodyValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Errors errors) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }
}
