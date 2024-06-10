package com.webservice.project.resources;

import com.webservice.project.entities.User;
import com.webservice.project.services.UserServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    //TODO Adicionar REGEX para telefone, email
    @Autowired
    private UserServices userServices;

    @PostMapping
    public ResponseEntity<URI> insert(@RequestBody @Validated User user) {
        userServices.insert(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.ok()
                .location(location)
                .build();
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = userServices.findAll();

        return ResponseEntity.ok()
                .body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userServices.findById(id);
        return ResponseEntity.ok()
                .body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id){
        User user = userServices.findById(id);
        userServices.delete(user.getId());
        return ResponseEntity.ok()
                .build();
    }

}
