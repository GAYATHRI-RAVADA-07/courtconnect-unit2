package com.courtconnect.backend.controller;

import com.courtconnect.backend.model.CourtOperatingHours;
import com.courtconnect.backend.repository.CourtOperatingHoursRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/court-operating-hours")
public class CourtOperatingHoursController {

    private final CourtOperatingHoursRepository courtOperatingHoursRepository;

    public CourtOperatingHoursController(CourtOperatingHoursRepository courtOperatingHoursRepository) {
        this.courtOperatingHoursRepository = courtOperatingHoursRepository;
    }

    @PostMapping
    public CourtOperatingHours createCourtOperatingHours(
            @Valid @RequestBody CourtOperatingHours courtOperatingHours) {
        return courtOperatingHoursRepository.save(courtOperatingHours);
    }

    @GetMapping
    public List<CourtOperatingHours> getAllCourtOperatingHours() {
        return courtOperatingHoursRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourtOperatingHours> getCourtOperatingHoursById(@PathVariable Long id) {
        return courtOperatingHoursRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
