package com.jobportalbackend.jobportalbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    @JsonBackReference
    private Job job;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @Column(nullable = false)
    private ApplicationEnum applicationEnum;

    private LocalDateTime applied_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
