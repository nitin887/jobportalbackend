package com.jobportalbackend.jobportalbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception for when an Application is not found.
 * Returns HTTP 404 Not Found status.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApplicationNotFoundException extends RuntimeException {

    public ApplicationNotFoundException(String message) {
        super(message);
    }

    public ApplicationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
