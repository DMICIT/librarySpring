package com.project.controllers;


import com.project.data.UserPrincipal;
import com.project.entities.Book;
import com.project.entities.Order;
import com.project.entities.User;
import com.project.enums.BookSpot;
import com.project.enums.Status;
import com.project.services.OrderService;
import com.project.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
public class OrderController {

    @Resource
    private UserService userService;

    @Resource
    private OrderService orderService;

    @GetMapping(value = "/orders")
    public String getOrders(HttpServletRequest request) {

        HttpSession session = request.getSession();
        UserPrincipal user = (UserPrincipal) session.getAttribute("user");
        if (user != null) {
            User userByEmail = userService.getUserByEmail(user.getEmail());
            int usersId = userByEmail.getId();
            List<Order> allOrdersByUser = orderService.getAllOrdersByUser(usersId);

            request.setAttribute("allOrdersByUser", allOrdersByUser);
        }
        return "orders";
    }

    @PostMapping(value = "/orders")
    public String createOrder(HttpServletRequest request) {

        HttpSession session = request.getSession();
        UserPrincipal userPrincipal = (UserPrincipal) session.getAttribute("user");
        if (userPrincipal == null) {
            return "redirect:login";
        }
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        BookSpot bookSpot = BookSpot.valueOf(request.getParameter("action"));
        //TODO move to Orders Service.create()
        Book book = new Book();
        book.setId(bookId);

        User userByEmail = userService.getUserByEmail(userPrincipal.getEmail());
        LocalDate returnDate = null;

        if (bookSpot.equals(BookSpot.ABONEMENT)) {
            returnDate = LocalDate.now().plusMonths(1);
        }
        if (bookSpot.equals(BookSpot.LIBRARY_HALL)) {
            returnDate = LocalDate.now().plusDays(1);
        }

        Order order = new Order(0, userByEmail, book, bookSpot, Status.EXPECTED, returnDate);
        orderService.create(order);

        return "redirect:order";
    }

}
