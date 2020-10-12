package com.andoliv.healthcare.healthcareservice.exception;

import com.andoliv.healthcare.healthcareservice.external.ExtRestApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.andoliv.healthcare.healthcareservice.constants.ApiExceptionMessages.*;
import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * The Api Exception Handler centralize and handle all exception thrown in API
 *
 * @author anderson.oliveira
 */
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error(PARSE_THE_QUERYSTRING_MESSAGE, ex);
        return new ResponseEntity<>(new ExtRestApiError(ex, status, PARSE_THE_QUERYSTRING_MESSAGE), new HttpHeaders(),
                status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error(PARSE_THE_HTTP_MESSAGE, ex);
        return new ResponseEntity<>(new ExtRestApiError(ex, status, PARSE_THE_HTTP_MESSAGE), new HttpHeaders(), status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
                                                                     HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOG.error(UPLOAD_MEDIA_MESSAGE, ex);
        return new ResponseEntity<>(new ExtRestApiError(ex, status, UPLOAD_MEDIA_MESSAGE), new HttpHeaders(), status);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
                                                               HttpStatus status, WebRequest request) {
        LOG.error(EXECUTE_URL_MESSAGE, ex);
        return new ResponseEntity<>(new ExtRestApiError(ex, status, EXECUTE_URL_MESSAGE), new HttpHeaders(), status);
    }

    @ExceptionHandler(InstitutionNotFoundException.class)
    public ResponseEntity<ExtRestApiError> handleInstitutionNotFoundException(InstitutionNotFoundException ex, WebRequest request) {
        HttpStatus status = NOT_FOUND;
        LOG.error(INSTITUTION_NOT_FOUND_MESSAGE, ex);
        return new ResponseEntity<>(new ExtRestApiError(ex, status, INSTITUTION_NOT_FOUND_MESSAGE), new HttpHeaders(), status);
    }

    @ExceptionHandler(InstitutionOutOfBudgetException.class)
    public ResponseEntity<ExtRestApiError> handleInstitutionOutOfBudgetException(InstitutionOutOfBudgetException ex, WebRequest request) {
        HttpStatus status = NOT_ACCEPTABLE;
        LOG.error(INSTITUTION_NOT_FOUND_MESSAGE, ex);
        return new ResponseEntity<>(new ExtRestApiError(ex, status, INSTITUTION_OUT_OF_BUDGET_MESSAGE), new HttpHeaders(), status);
    }

    @ExceptionHandler(ExamNotFoundException.class)
    public ResponseEntity<ExtRestApiError> handleExamNotFoundException(ExamNotFoundException ex, WebRequest request) {
        HttpStatus status = NOT_FOUND;
        LOG.error(EXAM_NOT_FOUND_MESSAGE, ex);
        return new ResponseEntity<>(new ExtRestApiError(ex, status, EXAM_NOT_FOUND_MESSAGE), new HttpHeaders(), status);
    }
}
