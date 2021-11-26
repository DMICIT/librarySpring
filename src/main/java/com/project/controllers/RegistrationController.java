package com.project.controllers;

import com.project.entities.User;
import com.project.forms.RegistrationForm;
import com.project.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/registration")
    public String registrationPage(){
        return "registration";
    }

    @PostMapping(value= "/registration")
    public String userRegistration(HttpServletRequest request){
        RegistrationForm registrationForm = getRegistrationForm(request);
        User userByEmail = userService.getUserByEmail(registrationForm.getEmail());
        if(userByEmail == null) {
            userService.createUser(userByEmail);
            return "redirect:login";
        }
        return "registration";
    }
    private RegistrationForm getRegistrationForm(HttpServletRequest request) {
        return new RegistrationForm(request.getParameter("name"), request.getParameter("email"), request.getParameter("sex"),
                request.getParameter("phone"), request.getParameter("password"), request.getParameter("confirm_password"));
    }
}
