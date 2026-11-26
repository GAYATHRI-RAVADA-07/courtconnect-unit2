package com.courtconnect.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "facility_manager_profiles")
public class FacilityManagerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Phone number is required")
    @Column(nullable = false)
    private String phone;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    public FacilityManagerProfile() {

    }

    public FacilityManagerProfile(String phone, User user){
        this.phone = phone;
        this.user = user;
    }

    public Long getId(){
        return id;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }
}
