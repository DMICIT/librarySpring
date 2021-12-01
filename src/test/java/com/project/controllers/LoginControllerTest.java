package com.project.controllers;

import com.project.forms.LoginForm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;

    @Mock
    private LoginForm loginForm;

    @Test
    void testLoginPage() {

        String result = loginController.loginPage(loginForm);

        assertEquals("login", result);
    }
}