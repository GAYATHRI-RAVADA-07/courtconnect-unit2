package com.courtconnect.backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;


@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Sport is required")
    @Column(nullable = false)
    private String sport;

    @NotBlank(message = "SkillLevel is required")
    @Column(nullable = false)
    private String skillLevel;

    @NotNull(message = "Maximum players is required")
    @Column(nullable = false)
    @Min(value = 1, message = "Maximum players must be at least 1")
    private Integer maxPlayers;

    private String description;

    @NotNull(message = "Match status is required")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MatchStatus status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by_player_id", nullable = false)
    private PlayerProfile createdByPlayer;

    @OneToOne
    @JoinColumn(name = "availability_id", nullable = false, unique = true)
    private CourtAvailability availability;

    public Match() {
    }

    public Match(String sport, String skillLevel, Integer maxPlayers, String description,
                 MatchStatus status, PlayerProfile createdByPlayer, CourtAvailability availability) {
        this.sport = sport;
        this.skillLevel = skillLevel;
        this.maxPlayers = maxPlayers;
        this.description = description;
        this.status = status;
        this.createdByPlayer = createdByPlayer;
        this.availability = availability;
    }

    public Long getId(){
        return id;
    }

    public String getSport(){
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getSkillLevel(){
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel){
        this.skillLevel = skillLevel;
    }

    public Integer getMaxPlayers(){
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers){
        this.maxPlayers = maxPlayers;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MatchStatus getStatus() {
        return status;
    }

    public void setStatus(MatchStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public PlayerProfile getCreatedByPlayer() {
        return createdByPlayer;
    }

    public void setCreatedByPlayer(PlayerProfile createdByPlayer) {
        this.createdByPlayer = createdByPlayer;
    }

    public CourtAvailability getAvailability() {
        return availability;
    }

    public void setAvailability(CourtAvailability availability) {
        this.availability = availability;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

}
