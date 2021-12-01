package com.project.services;

import com.project.data.UserPrincipal;
import com.project.entities.Book;
import com.project.entities.Catalog;
import com.project.entities.Order;
import com.project.entities.User;
import com.project.enums.BookSpot;
import com.project.enums.Status;
import com.project.repositories.BookRepository;
import com.project.repositories.CatalogRepository;
import com.project.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private UserService userService;

    @Resource
    private BookRepository bookRepository;

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private CatalogRepository catalogRepository;

    public List<Order> findAllOrdersWithPenalty(int userId) {
        List<Order> byUserIdAndStatusAndReturnDateBefore = orderRepository.findByUserIdAndStatusAndReturnDateBefore(userId, Status.CHECKED_OUT, LocalDate.now());
        return byUserIdAndStatusAndReturnDateBefore;
    }

    public List<Order> getAllOrdersByUser(int userId) {

        List<Order> allOrdersByUsersId = orderRepository.findByUserIdAndStatusNot(userId, Status.RETURNED);
        return allOrdersByUsersId;
    }

    @Transactional
    public void create(int bookId, String email, BookSpot bookSpot) {

        Book book = bookRepository.getById(bookId);
        Catalog catalog = book.getCatalog();
        if (catalog != null && catalog.getCount() > 0) {


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
            int newCount = catalog.getCount()-1;
            catalog.setCount(newCount);
            catalogRepository.save(catalog);
        }

    }

    public List<Order> getAllActualOrders() {
        return orderRepository.findOrderByStatusNot(Status.RETURNED);
    }

    @Transactional
    public void changeStatus(int id, Status status) {

        Order byId = orderRepository.getById(id);
        byId.setStatus(status);
        orderRepository.save(byId);
        if (status == Status.RETURNED){
            Catalog catalog = byId.getBook().getCatalog();
            int newCount = catalog.getCount() +1;
            catalog.setCount(newCount);
            catalogRepository.save(catalog);
        }
    }
}
