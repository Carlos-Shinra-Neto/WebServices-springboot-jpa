package com.webservice.project.services;

import com.webservice.project.entities.Order;
import com.webservice.project.entities.User;
import com.webservice.project.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        return orderRepository.findById(id).orElseThrow
                (RuntimeException::new);
    }

    public void delete(Long id) {
        Order order = findById(id);
        orderRepository.delete(order);
    }

    public void insert(Order order){
        orderRepository.save(order);
    }
}
