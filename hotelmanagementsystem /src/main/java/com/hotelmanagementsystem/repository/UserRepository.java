package com.hotelmanagementsystem.repository;

import com.hotelmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByRole(String role);
}
