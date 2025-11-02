package com.jobportalbackend.jobportalbackend.entity;

import jakarta.persistence.*;

@Entity
public class Recruiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn
    @OneToOne
    private User user;
    @Column(unique = true,nullable = false)
    private  String companyName;
    @Column(unique = true,nullable = false)
    private Long contact_info;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getContact_info() {
        return contact_info;
    }

    public void setContact_info(Long contact_info) {
        this.contact_info = contact_info;
    }
}
