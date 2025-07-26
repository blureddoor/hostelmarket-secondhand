package com.hostelmarket.secondhand.repository;

import com.hostelmarket.secondhand.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Consultas extra (findByUsername, etc) se pueden añadir después
}
