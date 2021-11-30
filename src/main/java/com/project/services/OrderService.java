package com.project.services;

import com.project.data.UserPrincipal;
import com.project.entities.Book;
import com.project.entities.Order;
import com.project.entities.User;
import com.project.enums.BookSpot;
import com.project.enums.Status;
import com.project.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private UserService userService;

    @Resource
    private BookService bookService;

    @Resource
    private OrderRepository orderRepository;

    public List<Order> findAllOrdersWithPenalty(int userId){
        List<Order> byUserIdAndStatusAndReturnDateBefore = orderRepository.findByUserIdAndStatusAndReturnDateBefore(userId, Status.CHECKED_OUT, LocalDate.now());
        return byUserIdAndStatusAndReturnDateBefore;
    }

    public List<Order> getAllOrdersByUser(int userId) {

        List<Order> allOrdersByUsersId = orderRepository.findByUserIdAndStatusNot(userId,Status.RETURNED);
        return allOrdersByUsersId;
    }

    public void create(int bookId, String email, BookSpot bookSpot){

        Book book = new Book();
        book.setId(bookId);

        User userByEmail = userService.getUserByEmail(email);
        LocalDate returnDate = null;

        if (bookSpot.equals(BookSpot.ABONEMENT)) {
            returnDate = LocalDate.now().plusMonths(1);
        }
        if (bookSpot.equals(BookSpot.LIBRARY_HALL)) {
            returnDate = LocalDate.now().plusDays(1);
        }

        Order order = new Order(0, userByEmail, book, bookSpot, Status.EXPECTED, returnDate);

       orderRepository.save(order);
    }

    public List<Order> getAllActualOrders(){
        return orderRepository.findOrderByStatusNot(Status.RETURNED);
    }

    public void changeStatus (int id , Status status){

        Order byId = orderRepository.getById(id);
        byId.setStatus(status);
        orderRepository.save(byId);
    }
}
