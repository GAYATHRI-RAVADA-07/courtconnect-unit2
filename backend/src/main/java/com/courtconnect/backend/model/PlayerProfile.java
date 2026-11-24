package com.courtconnect.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_profiles")
public class PlayerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillLevel;
    private String phone;
    private String aboutMe;

    public PlayerProfile() {
    }

    public PlayerProfile(String skillLevel, String phone, String aboutMe) {
        this.skillLevel = skillLevel;
        this.phone = phone;
        this.aboutMe = aboutMe;
    }


    public Long getId() {
        return id;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String AboutMe) {
        this.aboutMe = aboutMe;
    }
}