package com.jobportalbackend.jobportalbackend.exception;

public class JobSeekerAlreadyExistException extends RuntimeException {
    public JobSeekerAlreadyExistException(String message) {
        super(message);
    }
}
