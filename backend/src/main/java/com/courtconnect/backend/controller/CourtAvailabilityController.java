package com.courtconnect.backend.controller;

import com.courtconnect.backend.model.CourtAvailability;
import com.courtconnect.backend.repository.CourtAvailabilityRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/court-availabilities")
public class CourtAvailabilityController {

    private final CourtAvailabilityRepository courtAvailabilityRepository;

    public CourtAvailabilityController(CourtAvailabilityRepository courtAvailabilityRepository) {
        this.courtAvailabilityRepository = courtAvailabilityRepository;
    }

    @PostMapping
    public CourtAvailability createCourtAvailability(@Valid @RequestBody CourtAvailability courtAvailability){
        return courtAvailabilityRepository.save(courtAvailability);
    }

    @GetMapping
    public List<CourtAvailability> getAllCourtAvailabilities(){
        return courtAvailabilityRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourtAvailability> getCourtAvailabilityById(@PathVariable Long id) {
        return courtAvailabilityRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
