package com.webservice.project.resources;

import com.webservice.project.entities.Order;
import com.webservice.project.entities.User;
import com.webservice.project.services.OrderService;
import com.webservice.project.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResources {

    //TODO Adicionar REGEX para telefone, email
    @Autowired
    private OrderService orderServices;

    @PostMapping
    public ResponseEntity<URI> insert(@RequestBody @Validated Order order) {
        orderServices.insert(order);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(order.getId())
                .toUri();

        return ResponseEntity.ok()
                .location(location)
                .build();
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = orderServices.findAll();

        return ResponseEntity.ok()
                .body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order = orderServices.findById(id);
        return ResponseEntity.ok()
                .body(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> delete(@PathVariable Long id){
        Order order = orderServices.findById(id);
        orderServices.delete(order.getId());
        return ResponseEntity.ok()
                .build();
    }

}
