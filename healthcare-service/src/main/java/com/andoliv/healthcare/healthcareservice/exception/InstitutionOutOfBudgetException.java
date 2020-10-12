package com.andoliv.healthcare.healthcareservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Institution out of budget Exception is thrown when a requested Institution resource is out of budget
 *
 * @author anderson.oliveira
 */
@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class InstitutionOutOfBudgetException extends RuntimeException {

    private static final long serialVersionUID = 8778626526806305185L;

    public InstitutionOutOfBudgetException(String message) {
        super(message);
    }
}
