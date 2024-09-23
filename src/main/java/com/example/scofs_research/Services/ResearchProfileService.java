package com.example.scofs_research.Services;

import com.example.scofs_research.Models.ResearchProfile;
import com.example.scofs_research.Repositories.ResearchProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResearchProfileService {
    @Autowired
    private ResearchProfileRepository repository;

}
