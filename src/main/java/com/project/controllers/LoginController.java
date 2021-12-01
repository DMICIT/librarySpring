package com.project.controllers;

import com.project.data.UserPrincipal;
import com.project.entities.User;
import com.project.forms.LoginForm;
import com.project.services.PenaltyService;
import com.project.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    @GetMapping(value ="/login")
    public String loginPage(LoginForm loginForm){
        return "login";
    }


}
