package com.courtconnect.backend.repository;

import com.courtconnect.backend.model.FacilityManagerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityManagerProfileRepository
        extends JpaRepository<FacilityManagerProfile, Long> {
}
