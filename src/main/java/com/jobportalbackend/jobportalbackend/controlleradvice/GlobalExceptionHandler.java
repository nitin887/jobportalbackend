package com.jobportalbackend.jobportalbackend.controlleradvice;

import com.jobportalbackend.jobportalbackend.dto.ExceptionResponseDto;
import com.jobportalbackend.jobportalbackend.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ExceptionResponseDto> handleUserAlreadyExistException(UserAlreadyExistException ex, WebRequest request) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ApplicationAlreadyExistException.class)
    public ResponseEntity<ExceptionResponseDto> handleApplicationAlreadyExistException(ApplicationAlreadyExistException ex, WebRequest request) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ApplicationNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleApplicationNotFoundException(ApplicationNotFoundException ex, WebRequest request) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(JobAlreadyExistException.class)
    public ResponseEntity<ExceptionResponseDto> handleJobAlreadyExistException(JobAlreadyExistException ex, WebRequest request) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleJobNotFoundException(JobNotFoundException ex, WebRequest request) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(JobSeekerAlreadyExistException.class)
    public ResponseEntity<ExceptionResponseDto> handleJobSeekerAlreadyExistException(JobSeekerAlreadyExistException ex, WebRequest request) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(JobSeekerNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleJobSeekerNotFoundException(JobSeekerNotFoundException ex, WebRequest request) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RecruiterAlreadyExistException.class)
    public ResponseEntity<ExceptionResponseDto> handleRecruiterAlreadyExistException(RecruiterAlreadyExistException ex, WebRequest request) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RecuriterAlreadyExistException.class) // Handling the typo version as well
    public ResponseEntity<ExceptionResponseDto> handleRecuriterAlreadyExistException(RecuriterAlreadyExistException ex, WebRequest request) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RecruiterNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleRecruiterNotFoundException(RecruiterNotFoundException ex, WebRequest request) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> handleGlobalException(Exception ex, WebRequest request) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
