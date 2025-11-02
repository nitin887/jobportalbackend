package com.jobportalbackend.jobportalbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecruiterDto {
    private Long id;
    private Long userId;
    private String companyName;
    private Long contact_info;
}
