package com.example.scofs_research.Controller;

import com.example.scofs_research.Models.Project;
import com.example.scofs_research.Models.Users;
import com.example.scofs_research.Repositories.ProjectRepositories;
import com.example.scofs_research.Repositories.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scofs-research/projects")
public class ProjectController {
    @Autowired
    private ProjectRepositories repository;
    @Autowired
    private User userRepository;

    // Get all research profiles for a user
    @GetMapping("/user/{userId}")
    public List<Project> getAllProjectsByUser(@PathVariable Long userId) {
        return repository.findByUserId(userId);
    }

    // Create research profile
    @PostMapping("/user/{userId}")
    public ResponseEntity<Project> createProject(@PathVariable Long userId, @RequestBody Project projectRequest) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        projectRequest.setUsers(user);
        Project project = repository.save(projectRequest);
        return ResponseEntity.ok(project);
    }

    // Update research profile
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project projectRequest) {
        Project project = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        project.setProjectTopic(projectRequest.getProjectTopic());
        project.setPublication(projectRequest.getPublication());
        repository.save(project);
        return ResponseEntity.ok(project);
    }

    // Delete research profile
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
