package com.courtconnect.backend.controller;

import com.courtconnect.backend.model.FacilityManagerProfile;
import com.courtconnect.backend.repository.FacilityManagerProfileRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facility-manager-profiles")
public class FacilityManagerProfileController {

    private final FacilityManagerProfileRepository facilityManagerProfileRepository;

    public FacilityManagerProfileController(
            FacilityManagerProfileRepository facilityManagerProfileRepository) {
        this.facilityManagerProfileRepository = facilityManagerProfileRepository;
    }

    @PostMapping
    public FacilityManagerProfile createFacilityManagerProfile(
            @Valid @RequestBody FacilityManagerProfile profile) {
        return facilityManagerProfileRepository.save(profile);
    }

    @GetMapping
    public List<FacilityManagerProfile> getAllFacilityManagerProfiles(){
        return facilityManagerProfileRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacilityManagerProfile> getFacilityManagerProfileById(
            @PathVariable Long id) {
        return facilityManagerProfileRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



}
