package com.project.services;

import com.project.entities.User;
import com.project.enums.Role;
import com.project.forms.AdminAddLibrarianForm;
import com.project.forms.RegistrationForm;
import com.project.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    public User createUserFromForm(RegistrationForm form, Role role) {

        User user = new User();
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setGender(form.getGender());
        user.setPhone(form.getPhone());
        user.setPassword(form.getPassword());
        user.setRole(role);
        return createUser(user);
    }

    public User createUserFromForm(AdminAddLibrarianForm form, Role role) {

        User user = new User();
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setGender(form.getGender());
        user.setPassword(form.getPassword());
        user.setPhone(form.getPhone());
        user.setRole(role);

        return createUser(user);
    }

    public List<User> getUsersByRole(Role role) {
        return userRepository.findUserByRole(role);
    }

    public void deleteUser(int id) {
        User user = userRepository.getById(id);
        if (user.getRole() == Role.LIBRARIAN) {
            userRepository.delete(user);
        }
    }


    public void banUser(int id, boolean value) {
        User user = userRepository.getById(id);
        user.setBanList(value);
        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById (int id){
        return userRepository.getById(id);
    }
}
