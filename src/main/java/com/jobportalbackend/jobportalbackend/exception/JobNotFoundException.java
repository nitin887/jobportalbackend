package com.jobportalbackend.jobportalbackend.exception;

public class JobNotFoundException extends RuntimeException {
    public JobNotFoundException(String message) {
        super(message);
    }
}
