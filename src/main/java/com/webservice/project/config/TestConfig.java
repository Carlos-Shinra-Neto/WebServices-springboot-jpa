package com.webservice.project.config;

import com.webservice.project.entities.Order;
import com.webservice.project.entities.User;
import com.webservice.project.repository.OrderRepository;
import com.webservice.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User( "Pedro Cielo", "pedro@gmail.com", "99999-9999", "123456");
        User u2 = new User( "Carlos Neto", "carlos@gmail.com", "98888-8888", "123456");
        User u3 = new User( "Rafael Senna", "rafael@gmail.com", "9777-7777", "123456");
        User u4 = new User( "Cristian Jonatas", "cristian@gmail.com", "96666-6666", "123456");

        Order o1 = new Order(Instant.parse("2018-02-23T08:30:32Z"), u1);
        Order o2 = new Order(Instant.parse("2018-04-06T12:42:55Z"), u2);
        Order o3 = new Order(Instant.parse("2018-10-02T17:32:56Z"), u1);


        userRepository.saveAll(Arrays.asList(u1,u2,u3,u4));

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
