package com.example.scofs_research.Repositories;

import com.example.scofs_research.Models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepositories extends JpaRepository<Project,Long> {

    List<Project> findByUserId(Long userId);
}
