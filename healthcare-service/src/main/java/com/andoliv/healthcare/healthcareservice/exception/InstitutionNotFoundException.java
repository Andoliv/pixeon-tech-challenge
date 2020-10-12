package com.andoliv.healthcare.healthcareservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Institution Not Found Exception is thrown when a requested institution resource is not found
 *
 * @author anderson.oliveira
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class InstitutionNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 57630211093475177L;

    public InstitutionNotFoundException(String message) {
        super(message);
    }
}
