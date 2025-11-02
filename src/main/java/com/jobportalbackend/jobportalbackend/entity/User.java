package com.jobportalbackend.jobportalbackend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String name;
    @Column(unique = true)
    private String email;

    private String role;
    @Column(unique = true,nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Application> applications;
}
