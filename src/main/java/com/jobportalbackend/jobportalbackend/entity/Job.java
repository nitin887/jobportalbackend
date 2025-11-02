package com.jobportalbackend.jobportalbackend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String tile;
    private String description;
    private String location;
    private Long salary;
    @OneToMany
    @JoinColumn(name ="job_opening_recruiter" )
    private List<Recruiter> recruiter;
    private LocalDateTime created_at;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Application> applications;
}
