package com.project.controllers;

import com.project.entities.User;
import com.project.enums.Role;
import com.project.forms.RegistrationForm;
import com.project.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegistrationControllerTest {

    @InjectMocks
    private RegistrationController registrationController;

    @Mock
    private RegistrationForm registrationForm;
    @Mock
    private UserService userService;
    @Mock
    private User user;

    @Mock
    private BindingResult errors;

    @Test
    void getRegistrationPage() {

        String result = registrationController.registrationPage(registrationForm);

        assertEquals("registration",result);
    }

    @Test
    void testUserRegistrationIfHasErrors() {

        when(errors.hasErrors()).thenReturn(true);
        String result = registrationController.userRegistration(registrationForm, errors);
        assertEquals("registration", result);
    }

    @Test
    void testUserRegistrationWhenEmailNull(){
        when(registrationForm.getEmail()).thenReturn("email");
        when(userService.getUserByEmail("email")).thenReturn(null);

        String result = registrationController.userRegistration(registrationForm, errors);

        assertEquals("redirect:login",result);
        verify(userService).createUserFromForm(registrationForm, Role.USER);
    }

    @Test
    void testUserRegistrationWhenEmailNotNull() {

        when(registrationForm.getEmail()).thenReturn("email");
        when(userService.getUserByEmail("email")).thenReturn(user);

        String result = registrationController.userRegistration(registrationForm, errors);

        assertEquals("registration",result);
        verify(errors).addError(any(ObjectError.class));
    }
}
