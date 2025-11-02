package com.jobportalbackend.jobportalbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
    private Long id;
    private String tile;
    private String description;
    private String location;
    private Long salary;
    private List<RecruiterDto> recruiterDto;
    private LocalDateTime created_at;
}
