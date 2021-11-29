package com.project.controllers;

import com.project.data.UserPrincipal;
import com.project.entities.User;
import com.project.forms.LoginForm;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Collections;

@Controller
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private UserService userService;

    @GetMapping(value ="/login")
    public String loginPage(LoginForm loginForm){
        return "login";
    }

    @PostMapping(value="/login")
    public String loginUser(HttpServletRequest request, @Valid @ModelAttribute LoginForm loginForm, BindingResult errors){

        LOG.info("Form: {}, errors: {}", loginForm, errors);
        if (errors.hasErrors()){
            return "login";
        }
        User userByEmail = userService.getUserByEmail(loginForm.getEmail());

        if (userByEmail == null) {
            errors.addError(new ObjectError("formErrors", new String[]{"user.not.exist"}, null, "User not exist"));
            return "login";
        }
        if (!userByEmail.getPassword().equals(loginForm.getPassword())) {
            errors.addError(new ObjectError("formErrors", new String[]{"password.not.correct"}, null, "Incorrect login or password"));
            return "login";
        }
        if (userByEmail.isBanList()){
            return "ban-page";
        }

        HttpSession session = request.getSession();
        UserPrincipal userPrincipal = new UserPrincipal(userByEmail.getEmail(),userByEmail.getRole());
        session.setAttribute("user", userPrincipal);

        return "redirect:";

    }

}
