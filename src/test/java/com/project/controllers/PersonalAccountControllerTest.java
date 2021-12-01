package com.project.controllers;

import com.project.entities.User;
import com.project.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.security.Principal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonalAccountControllerTest {

    @InjectMocks
    private PersonalAccountController personalAccountController;

    @Mock
    private UserService userService;

    @Mock
    private Principal principal;

    @Mock
    private User user;

    @Mock
    private Model model;

    @Test
    void testPersonalAccountPage() {

        when(principal.getName()).thenReturn("email");
        when(userService.getUserByEmail("email")).thenReturn(user);

        String result = personalAccountController.getAccountPage(principal,model);

        assertEquals("personal-account", result);
        verify(model).addAttribute("user",user);
    }
}