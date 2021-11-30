package com.project.repositories;

import com.project.entities.User;
import com.project.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
    List<User> findUserByRole(Role role);
}
