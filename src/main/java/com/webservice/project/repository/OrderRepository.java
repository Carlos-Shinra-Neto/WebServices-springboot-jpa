package com.webservice.project.repository;

import com.webservice.project.entities.Order;
import com.webservice.project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
