package com.project.services;

import com.project.entities.Order;
import com.project.enums.Status;
import com.project.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private UserService userService;

    @Resource
    private BookService bookService;

    @Resource
    private OrderRepository orderRepository;

    public List<Order> getAllOrdersByUser(int userId) {

        List<Order> allOrdersByUsersId = orderRepository.findByUserIdAndStatusNot(userId,Status.RETURNED);
        return allOrdersByUsersId;
    }

    public void create(Order order){
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
