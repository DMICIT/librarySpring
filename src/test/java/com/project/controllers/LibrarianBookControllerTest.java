package com.project.controllers;

import com.project.entities.Order;
import com.project.entities.User;
import com.project.enums.Role;
import com.project.enums.Status;
import com.project.services.OrderService;
import com.project.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LibrarianBookControllerTest {

    @InjectMocks
    private LibrarianBookController librarianBookController;

    @Mock
    private OrderService orderService;

    @Mock
    private UserService userService;

    @Mock
    private Model model;

    @Mock
    private Order order;

    @Mock
    private User user;


    @Test
    void testLibrarianOrdersPage() {

        List<Order> orders = Collections.singletonList(order);
        when(orderService.getAllActualOrders()).thenReturn(orders);
        String result = librarianBookController.librarianOrders(model);

        assertEquals("librarian-orders", result);
        verify(model).addAttribute("orders", orders);
    }

    @Test
    void testGetAllUsers() {

        List<User> users = Collections.singletonList(user);
        when(userService.getUsersByRole(Role.USER)).thenReturn(users);

        String result = librarianBookController.getAllUsers(model);
        verify(model).addAttribute("allUsers", users);

    }

    @Test
    void testGetUserAbonement() {

        List<Order> orders = Collections.singletonList(order);
        when(orderService.getAllOrdersByUser(2)).thenReturn(orders);
        when(userService.findUserById(2)).thenReturn(user);

        String result = librarianBookController.getUserAbonement(model, 2);

        assertEquals("user-abonement", result);
        verify(model).addAttribute("userAbonement",user);
        verify(model).addAttribute("ordersByUser",orders);

    }

//    @Test
//    void testLibrarianChangeStatus() {
//
//        String result = librarianBookController.librarianChangeStatus("", 2);
//
//        assertEquals("redirect:librarian-orders", result);
//        verify(orderService).changeStatus(2,);
//    }
}