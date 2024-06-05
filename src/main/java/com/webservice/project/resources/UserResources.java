package com.webservice.project.resources;

import com.webservice.project.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    //TODO Adicionar REGEX para telefone, email
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Carlos", "carlos@email.com", "993003-7373", "12345");
        return ResponseEntity.ok().body(u);
    }
}
