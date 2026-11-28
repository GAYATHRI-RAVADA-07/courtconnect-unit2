package com.courtconnect.backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrePersist;
import jakarta.persistence.UniqueConstraint;

import jakarta.validation.constraints.NotNull;

@Entity
@Table(
        name = "match_participations",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"player_id", "match_id"})
        }
)
public class MatchParticipation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Participation status is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ParticipationStatus status;

    @Column(nullable = false)
    private LocalDateTime joinedAt;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private PlayerProfile player;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;

    public MatchParticipation() {
    }

    public MatchParticipation(ParticipationStatus status, PlayerProfile player, Match match) {
        this.status = status;
        this.player = player;
        this.match = match;
    }

    public Long getId() {
        return id;
    }

    public ParticipationStatus getStatus() {
        return status;
    }

    public void setStatus(ParticipationStatus status) {
        this.status = status;
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }

    public PlayerProfile getPlayer() {
        return player;
    }

    public void setPlayer(PlayerProfile player) {
        this.player = player;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    @PrePersist
    protected void onCreate() {
        joinedAt = LocalDateTime.now();
    }
}
