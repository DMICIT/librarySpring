package com.project.controllers;

import com.project.data.UserPrincipal;
import com.project.entities.User;
import com.project.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PersonalAccountController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/personal-account", method = {RequestMethod.GET, RequestMethod.POST})
    public String getAccountPage(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserPrincipal userPrincipal = (UserPrincipal) session.getAttribute("user");
        User user = userService.getUserByEmail(userPrincipal.getEmail());
        request.setAttribute("user",user);

        return "personal-account";

    }
}
