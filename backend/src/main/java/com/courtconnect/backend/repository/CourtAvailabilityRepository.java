package com.courtconnect.backend.repository;

import com.courtconnect.backend.model.CourtAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtAvailabilityRepository extends JpaRepository<CourtAvailability, Long> {
}
