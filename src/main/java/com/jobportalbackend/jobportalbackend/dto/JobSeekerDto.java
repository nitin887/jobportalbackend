package com.jobportalbackend.jobportalbackend.dto;

public class JobSeekerDto {
    private Long id;
    private Long userId;
    private String resume_url;
    private String skills;
    private String experience;

    public JobSeekerDto() {
    }

    public JobSeekerDto(Long id, Long userId, String resume_url, String skills, String experience) {
        this.id = id;
        this.userId = userId;
        this.resume_url = resume_url;
        this.skills = skills;
        this.experience = experience;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
