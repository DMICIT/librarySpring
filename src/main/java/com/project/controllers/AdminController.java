package com.project.controllers;

import com.project.entities.User;
import com.project.enums.Role;
import com.project.forms.AdminAddLibrarianForm;
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
public class AdminController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/admin-add-librarian")
    public String adminAddUserPage() {
        return "admin-add-user";
    }

    @PostMapping(value = "/admin-add-librarian")
    public String addLibrarianByAdmin(HttpServletRequest request, @Valid @ModelAttribute RegistrationForm form, BindingResult errors){

        Role role = Role.LIBRARIAN;
        User user = userService.createUserfromForm(form, role);

        return "redirect:login";
    }
}
