package com.project.controllers;


import com.project.data.UserPrincipal;
import com.project.entities.Order;
import com.project.entities.User;
import com.project.enums.BookSpot;
import com.project.services.OrderService;
import com.project.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class OrderController {

    @Resource
    private UserService userService;

    @Resource
    private OrderService orderService;

    @GetMapping(value = "/orders")
    public String getOrders(Principal principal, Model model) {

        if (principal != null) {
            User userByEmail = userService.getUserByEmail(principal.getName());
            int usersId = userByEmail.getId();
            List<Order> allOrdersByUser = orderService.getAllOrdersByUser(usersId);

          model.addAttribute("allOrdersByUser", allOrdersByUser);
        }
        return "orders";
    }

    @PostMapping(value = "/orders")
    public String createOrder(Principal principal,
                              @RequestParam (defaultValue = "0" ,name = "bookId") Integer bookId,
                              @RequestParam (name = "action") BookSpot bookSpot) {

        if (principal == null) {
            return "redirect:login";
        }
        orderService.create(bookId,principal.getName(),bookSpot);
        return "redirect:orders";
    }

}
