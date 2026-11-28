package com.courtconnect.backend.repository;

import com.courtconnect.backend.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long>{
}
