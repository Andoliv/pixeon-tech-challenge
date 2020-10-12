package com.andoliv.healthcare.healthcareservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Exam Not Found Exception is thrown when a requested exam resource is not found
 *
 * @author anderson.oliveira
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ExamNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -8010444475002702292L;

    public ExamNotFoundException(String message) {
        super(message);
    }
}
