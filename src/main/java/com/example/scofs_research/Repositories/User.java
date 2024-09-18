package com.example.scofs_research.Repositories;

import com.example.scofs_research.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface User extends JpaRepository<Users, Long> {

    Optional<Users> findByUserName(String userName);
}
