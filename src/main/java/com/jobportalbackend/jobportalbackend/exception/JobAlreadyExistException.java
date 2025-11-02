package com.jobportalbackend.jobportalbackend.exception;

public class JobAlreadyExistException extends RuntimeException {
    public JobAlreadyExistException(String message) {
        super(message);
    }
}
