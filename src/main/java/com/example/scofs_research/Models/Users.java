package com.example.scofs_research.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long user_id;
    @Column(unique = true)
    public String userName;
    public String email;
}
