package com.courtconnect.backend.repository;

import com.courtconnect.backend.model.CourtOperatingHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtOperatingHoursRepository extends JpaRepository<CourtOperatingHours, Long> {
}
