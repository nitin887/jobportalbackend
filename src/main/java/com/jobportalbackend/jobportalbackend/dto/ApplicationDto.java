package com.jobportalbackend.jobportalbackend.dto;

import com.jobportalbackend.jobportalbackend.entity.ApplicationEnum;

import java.time.LocalDateTime;

public class ApplicationDto {
    private Long id;
    private Long jobId;
    private Long userId;
    private ApplicationEnum applicationEnum;
    private LocalDateTime applied_at;

    public ApplicationDto() {
    }

    public ApplicationDto(Long id, Long jobId, Long userId, ApplicationEnum applicationEnum, LocalDateTime applied_at) {
        this.id = id;
        this.jobId = jobId;
        this.userId = userId;
        this.applicationEnum = applicationEnum;
        this.applied_at = applied_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ApplicationEnum getApplicationEnum() {
        return applicationEnum;
    }

    public void setApplicationEnum(ApplicationEnum applicationEnum) {
        this.applicationEnum = applicationEnum;
    }

    public LocalDateTime getApplied_at() {
        return applied_at;
    }

    public void setApplied_at(LocalDateTime applied_at) {
        this.applied_at = applied_at;
    }
}
