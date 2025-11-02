package com.jobportalbackend.jobportalbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponseDto {
    private LocalDateTime timestamp;
    private String message;
    private String details;
    private HttpStatus errorCode;
}
