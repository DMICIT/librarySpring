package com.project.controllers;

import com.project.data.UserPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserPrincipal user =(UserPrincipal) session.getAttribute("user");
        if(user != null){
            session.invalidate();
        }
        return "redirect:";
    }
}
