package com.jobportalbackend.jobportalbackend.entity;

import jakarta.persistence.*;

@Entity
public class JobSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn
    @OneToOne
    private User user;
    private String resume_url;
    private String skills;
    private String experience;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getResume_url() {
        return resume_url;
    }

    public void setResume_url(String resume_url) {
        this.resume_url = resume_url;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
