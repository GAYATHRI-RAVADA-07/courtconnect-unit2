package com.courtconnect.backend.controller;

import com.courtconnect.backend.model.PlayerProfile;
import com.courtconnect.backend.repository.PlayerProfileRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/player-profiles")
public class PlayerProfileController {

    private final PlayerProfileRepository playerProfileRepository;

    public PlayerProfileController(PlayerProfileRepository playerProfileRepository) {
        this.playerProfileRepository = playerProfileRepository;
    }

    @PostMapping
    public PlayerProfile createPlayerProfile(@RequestBody PlayerProfile playerProfile){
        return playerProfileRepository.save(playerProfile);
    }

    @GetMapping
    public  List<PlayerProfile> getAllPlayerProfiles(){
        return playerProfileRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerProfile> getPlayerProfileById(@PathVariable Long id){
        return playerProfileRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
