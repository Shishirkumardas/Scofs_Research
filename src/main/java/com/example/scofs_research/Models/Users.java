package com.example.scofs_research.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Data
@Entity
@Getter
@Setter
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long user_id;
    @Column(unique = true,nullable = false)
    public String userName;
    @Column(nullable = false)
    public String email;
    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ResearchProfile> researchProfileList;
}
