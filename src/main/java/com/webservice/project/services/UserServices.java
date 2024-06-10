package com.webservice.project.services;

import com.webservice.project.entities.User;
import com.webservice.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow
                (RuntimeException::new);
    }

    public void delete(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }

    public void insert(User user){
        userRepository.save(user);
    }
}
