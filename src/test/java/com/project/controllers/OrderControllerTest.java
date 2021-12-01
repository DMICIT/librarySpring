package com.project.controllers;

import com.project.entities.Order;
import com.project.entities.User;
import com.project.enums.BookSpot;
import com.project.services.OrderService;
import com.project.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {


    @InjectMocks
    private OrderController orderController;

    @Mock
    private UserService userService;

    @Mock
    private OrderService orderService;
    @Mock
    private Model model;
    @Mock
    private User user;
    @Mock
    private Principal principal;
    @Mock
    private Order order;

    @Test
    void testWhenPrincipalIsNull() {

        String result = orderController.getOrders(null, model);

        verifyNoInteractions(model, orderService, userService);
        assertEquals("orders", result);

    }

    @Test
    void testWhenPrincipalNotNull() {

        when(principal.getName()).thenReturn("userEmail");
        when(userService.getUserByEmail("userEmail")).thenReturn(user);
        when(user.getId()).thenReturn(1);
        List<Order> orders = Collections.singletonList(order);
        when(orderService.getAllOrdersByUser(1)).thenReturn(orders);

        String result = orderController.getOrders(principal, model);

        assertEquals("orders", result);
        verify(model).addAttribute("allOrdersByUser",orders);
    }

    @Test
    void testCreateOrderWhenPrincipalNull() {
        String result = orderController.createOrder(null,null,null);

        assertEquals("redirect:login", result);
        verifyNoInteractions(orderService);
    }

    @Test
    void testCreateOrderWhenPrincipanNotNull() {
        when(principal.getName()).thenReturn("email");

        String result = orderController.createOrder(principal,1, BookSpot.ABONEMENT);

        assertEquals("redirect:orders", result);
        verify(orderService).create(1,"email",BookSpot.ABONEMENT);
    }
}