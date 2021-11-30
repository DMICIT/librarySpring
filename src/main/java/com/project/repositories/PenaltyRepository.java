package com.project.repositories;

import com.project.entities.Penalty;
import org.springframework.data.repository.CrudRepository;

public interface PenaltyRepository extends CrudRepository<Penalty, Integer> {

    Penalty findByOrderId(int orderId);
}
