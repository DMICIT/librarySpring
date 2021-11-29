package com.project.controllers;

import com.project.entities.User;
import com.project.enums.Role;
import com.project.forms.RegistrationForm;
import com.project.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/registration")
    public String registrationPage(){
        return "registration";
    }

    @PostMapping(value= "/registration")
    public String userRegistration(HttpServletRequest request, @Valid @ModelAttribute RegistrationForm registrationForm ,BindingResult errors){
        //TODO add form validation as in LoginController

        User userByEmail = userService.getUserByEmail(registrationForm.getEmail());
        if(userByEmail == null) {
            userService.createUserFromForm(registrationForm, Role.USER);
            return "redirect:login";
        }

        errors.reject("user.exist.error");
        return "registration";
    }
}
