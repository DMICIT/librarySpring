package com.project.controllers;

import com.project.data.UserPrincipal;
import com.project.entities.User;
import com.project.forms.LoginForm;
import com.project.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;

@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @GetMapping(value ="/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping(value="/login")
    public String loginUser(HttpServletRequest request){
        LoginForm loginForm = getLoginForm(request);
        User userByEmail = userService.getUserByEmail(loginForm.getEmail());

        if (userByEmail == null) {
            request.setAttribute("errorMessages", "User not found, please register");
            return "redirect:registration";
        }
        if (!userByEmail.getPassword().equals(loginForm.getPassword())) {
            request.setAttribute("errorMessages", Collections.singletonList("error.wrong.password"));
            return "login.jsp";
        }
        if (userByEmail.isBanList()){
            return "ban-page.jsp";
        }

        HttpSession session = request.getSession();
        UserPrincipal userPrincipal = new UserPrincipal(userByEmail.getEmail(),userByEmail.getRole());
        session.setAttribute("user", userPrincipal);

        return "redirect:";

    }

    private LoginForm getLoginForm(HttpServletRequest request) {
        return new LoginForm(request.getParameter("email"), request.getParameter("password"));
    }
}
