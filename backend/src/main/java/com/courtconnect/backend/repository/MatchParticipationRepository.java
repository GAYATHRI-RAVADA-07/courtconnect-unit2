package com.courtconnect.backend.repository;

import com.courtconnect.backend.model.MatchParticipation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchParticipationRepository extends JpaRepository<MatchParticipation, Long> {
}
