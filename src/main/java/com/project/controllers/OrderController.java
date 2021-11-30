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
import java.util.List;

@Controller
public class OrderController {

    @Resource
    private UserService userService;

    @Resource
    private OrderService orderService;

    @GetMapping(value = "/orders")
    public String getOrders( HttpSession session, Model model) {

        UserPrincipal user = (UserPrincipal) session.getAttribute("user");
        if (user != null) {
            User userByEmail = userService.getUserByEmail(user.getEmail());
            int usersId = userByEmail.getId();
            List<Order> allOrdersByUser = orderService.getAllOrdersByUser(usersId);

          model.addAttribute("allOrdersByUser", allOrdersByUser);
        }
        return "orders";
    }

    @PostMapping(value = "/orders")
    public String createOrder(HttpSession session,
                              @RequestParam (defaultValue = "0" ,name = "bookId") Integer bookId,
                              @RequestParam (name = "action") BookSpot bookSpot) {

        UserPrincipal userPrincipal = (UserPrincipal) session.getAttribute("user");
        if (userPrincipal == null) {
            return "redirect:login";
        }
        orderService.create(bookId,userPrincipal,bookSpot);
        return "redirect:orders";
    }

}
