package com.project.services;

import com.project.entities.Order;
import com.project.entities.Penalty;
import com.project.enums.Status;
import com.project.repositories.BookRepository;
import com.project.repositories.PenaltyRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
public class PenaltyService {

    @Resource
    private OrderService orderService;
    @Resource
    private PenaltyRepository penaltyRepository;


    public void checkUserPenalty(int userId) {
        List<Order> allOrdersByUser = orderService.findAllOrdersWithPenalty(userId);
        checkPenalty(allOrdersByUser);
    }


        private void checkPenalty(List<Order> allOrdersByUser) {
        for (Order order : allOrdersByUser) {
            Penalty penaltyByOrder = penaltyRepository.findByOrderId(order.getId());
            if (penaltyByOrder != null) {
                Penalty penalty = new Penalty(order, order.getUser(), 500);
                penaltyRepository.save(penalty);
            }
        }
    }


}
