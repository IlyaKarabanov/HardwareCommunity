package com.project_1.hardware_community.repositories;

import com.project_1.hardware_community.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}