package com.project.repositories;

import com.project.entities.Order;
import com.project.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByUserIdAndStatusNot(int userId, Status status);

    Page<Order> findByUserIdAndStatusNot(int userId, Status status, Pageable pageable);

    List<Order>findOrderByStatus(Status status);

    List<Order> findOrderByStatusNot(Status status);

}
