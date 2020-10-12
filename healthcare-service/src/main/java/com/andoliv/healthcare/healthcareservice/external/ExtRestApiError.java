package com.andoliv.healthcare.healthcareservice.external;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * The External Rest Api Error represents a detailed description of error occurred at runtime
 *
 * @author anderson.oliveira
 */
public class ExtRestApiError {

    private final int code;
    private final String status;
    private final LocalDateTime timestamp;
    private final String message;
    private final String reason;

    public ExtRestApiError(Exception exception, HttpStatus status, String message) {
        this.timestamp = LocalDateTime.now();
        this.code = status.value();
        this.status = status.getReasonPhrase();
        this.message = message;
        this.reason = exception.getMessage();
    }

    public ExtRestApiError(Exception exception, HttpStatus status, String message, String reason) {
        this.timestamp = LocalDateTime.now();
        this.code = status.value();
        this.status = status.getReasonPhrase();
        this.message = message;
        this.reason = reason;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getReason() {
        return reason;
    }

}
