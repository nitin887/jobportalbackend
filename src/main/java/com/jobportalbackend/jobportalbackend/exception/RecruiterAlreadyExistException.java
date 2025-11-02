package com.jobportalbackend.jobportalbackend.exception;

public class RecruiterAlreadyExistException extends RuntimeException {
    public RecruiterAlreadyExistException(String message) {
        super(message);
    }
}
