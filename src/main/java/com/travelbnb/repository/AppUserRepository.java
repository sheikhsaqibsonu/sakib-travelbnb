package com.travelbnb.repository;

import com.travelbnb.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    Optional<AppUser> findByUsername(String userName);
}