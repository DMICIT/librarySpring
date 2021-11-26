package com.project.services;

import com.project.entities.User;
import com.project.enums.Role;
import com.project.forms.RegistrationForm;
import com.project.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private User createUser(User user) {
        return userRepository.save(user);
    }

    public User createUserfromForm(RegistrationForm form, Role role) {

        User user = new User();
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setGender(form.getGender());
        user.setPassword(form.getPassword());
        user.setRole(role);
        return createUser(user);
    }
}
