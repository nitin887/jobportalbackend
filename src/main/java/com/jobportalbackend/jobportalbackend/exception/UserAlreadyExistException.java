package com.jobportalbackend.jobportalbackend.exception;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
