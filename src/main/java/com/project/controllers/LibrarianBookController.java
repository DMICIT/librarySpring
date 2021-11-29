package com.project.controllers;

import com.project.entities.Order;
import com.project.entities.User;
import com.project.enums.Role;
import com.project.enums.Status;
import com.project.services.OrderService;
import com.project.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class LibrarianBookController {

    @Resource
    private OrderService orderService;
    @Resource
    private UserService userService;

    @GetMapping(value = "/librarian-orders")
    public String librarianOrders(HttpServletRequest request){
        List<Order> orders = orderService.getAllActualOrders();

        request.setAttribute("orders", orders);
        return "librarian-orders";

    }

    @GetMapping (value = "/user-list")
    public String getAllUsers(HttpServletRequest request){
        List<User> users = userService.getUsersByRole(Role.USER);
        request.setAttribute("allUsers", users);
        return "user-list";
    }

    @GetMapping(value = "/user-abonement")
    public String getUserAbonement(HttpServletRequest request){
        int userId = Integer.parseInt(request.getParameter("userId"));
        List<Order> allOrdersByUser = orderService.getAllOrdersByUser(userId);
        User userById = userService.findUserById(userId);
        request.setAttribute("userAbonement", userById );
        request.setAttribute("ordersByUser", allOrdersByUser);
    return "user-abonement";
    }



    @PostMapping(value = "/librarian-orders")
    public String librarianChangeStatus (HttpServletRequest request){

        String action = request.getParameter("action");
        int orderId = Integer.parseInt(request.getParameter("orderId"));

        orderService.changeStatus(orderId, Status.valueOf(action));
        return "redirect:librarian-orders";

    }

}
