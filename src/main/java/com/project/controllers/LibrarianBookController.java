package com.project.controllers;

import com.project.entities.Order;
import com.project.entities.User;
import com.project.enums.Role;
import com.project.enums.Status;
import com.project.services.OrderService;
import com.project.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class LibrarianBookController {

    @Resource
    private OrderService orderService;
    @Resource
    private UserService userService;

    @GetMapping(value = "/librarian-orders")
    public String librarianOrders(Model model) {
        List<Order> orders = orderService.getAllActualOrders();

        model.addAttribute("orders", orders);
        return "librarian-orders";

    }

    @GetMapping(value = "/user-list")
    public String getAllUsers(Model model) {
        List<User> users = userService.getUsersByRole(Role.USER);
        model.addAttribute("allUsers", users);
        return "user-list";
    }

    @GetMapping(value = "/user-abonement")
    public String getUserAbonement(Model model,
                                   @RequestParam(defaultValue = "0", name = "userId") Integer userId) {
        List<Order> allOrdersByUser = orderService.getAllOrdersByUser(userId);
        User userById = userService.findUserById(userId);
        model.addAttribute("userAbonement", userById);
        model.addAttribute("ordersByUser", allOrdersByUser);
        return "user-abonement";
    }


    @PostMapping(value = "/librarian-orders")
    public String librarianChangeStatus(@RequestParam(defaultValue = "", name = "action") String action,
                                        @RequestParam(defaultValue = "0", name = "orderId") Integer orderId) {

        orderService.changeStatus(orderId, Status.valueOf(action));
        return "redirect:librarian-orders";

    }

}
