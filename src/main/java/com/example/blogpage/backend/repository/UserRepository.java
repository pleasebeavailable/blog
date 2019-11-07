package com.example.blogpage.backend.repository;

import com.example.blogpage.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
