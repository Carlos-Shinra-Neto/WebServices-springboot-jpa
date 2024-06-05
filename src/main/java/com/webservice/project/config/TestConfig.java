package com.webservice.project.config;

import com.webservice.project.entities.User;
import com.webservice.project.repository.UserRepository;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User( "Pedro Cielo", "pedro@gmail.com", "99999-9999", "123456");
        User u2 = new User( "Carlos Neto", "carlos@gmail.com", "98888-8888", "123456");
        User u3 = new User( "Rafael Senna", "rafael@gmail.com", "9777-7777", "123456");
        User u4 = new User( "Cristian Jonatas", "cristian@gmail.com", "96666-6666", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
    }
}
