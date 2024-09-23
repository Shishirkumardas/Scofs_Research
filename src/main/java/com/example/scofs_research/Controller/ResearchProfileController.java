package com.example.scofs_research.Controller;

import com.example.scofs_research.Models.ResearchProfile;
import com.example.scofs_research.Models.Users;
import com.example.scofs_research.Repositories.ResearchProfileRepository;
import com.example.scofs_research.Repositories.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scofs-research/research-profile")
public class ResearchProfileController {
    @Autowired
    private ResearchProfileRepository repository;
    @Autowired
    private User userRepository;

    // Get all research profiles for a user
    @GetMapping("/user/{userId}")
    public List<ResearchProfile> getAllResearchProfilesByUser(@PathVariable Long userId) {
        return repository.findByUserId(userId);
    }

    // Create research profile
    @PostMapping("/user/{userId}")
    public ResponseEntity<ResearchProfile> createResearchProfile(@PathVariable Long userId, @RequestBody ResearchProfile researchProfileRequest) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        researchProfileRequest.setUsers(user);
        ResearchProfile researchProfile = repository.save(researchProfileRequest);
        return ResponseEntity.ok(researchProfile);
    }

    // Update research profile
    @PutMapping("/{id}")
    public ResponseEntity<ResearchProfile> updateResearchProfile(@PathVariable Long id, @RequestBody ResearchProfile researchProfileRequest) {
        ResearchProfile researchProfile = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ResearchProfile not found"));
        researchProfile.setResearchTopic(researchProfileRequest.getResearchTopic());
        researchProfile.setPublication(researchProfileRequest.getPublication());
        repository.save(researchProfile);
        return ResponseEntity.ok(researchProfile);
    }

    // Delete research profile
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResearchProfile(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}





