package com.project.controllers;

import com.project.data.UserPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @GetMapping(value = "/logout")
    public String logout( HttpSession session){
        UserPrincipal user =(UserPrincipal) session.getAttribute("user");
        if(user != null){
            session.invalidate();
        }
        return "redirect:";
    }
}
