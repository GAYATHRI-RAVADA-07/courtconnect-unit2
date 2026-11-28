package com.courtconnect.backend.controller;

import com.courtconnect.backend.model.MatchParticipation;
import com.courtconnect.backend.repository.MatchParticipationRepository;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/match-participations")
public class MatchParticipationController {

    private final MatchParticipationRepository matchParticipationRepository;

    public MatchParticipationController(MatchParticipationRepository matchParticipationRepository) {
        this.matchParticipationRepository = matchParticipationRepository;
    }

    @PostMapping
    public MatchParticipation createParticipation(
            @Valid @RequestBody MatchParticipation participation) {
        return matchParticipationRepository.save(participation);
    }

    @GetMapping
    public List<MatchParticipation> getAllParticipations() {
        return matchParticipationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchParticipation> getParticipationById(@PathVariable Long id) {
        return matchParticipationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
