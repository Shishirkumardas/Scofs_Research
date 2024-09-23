package com.example.scofs_research.Repositories;

import com.example.scofs_research.Models.ResearchProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResearchProfileRepository extends JpaRepository<ResearchProfile,Long> {

    List<ResearchProfile> findByUserId(Long userId);
}
