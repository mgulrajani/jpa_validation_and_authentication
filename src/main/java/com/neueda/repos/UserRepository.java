package com.neueda.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neueda.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
