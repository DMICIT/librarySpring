package com.project.repositories;

import com.project.entities.User;
import com.project.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
    List<User> findUserByRole(Role role);
}
