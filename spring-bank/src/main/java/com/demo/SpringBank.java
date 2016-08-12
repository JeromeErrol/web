package com.demo;

import com.demo.domain.User;
import com.demo.domain.UserRole;
import com.demo.repositories.UserRepository;
import com.demo.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.annotation.PostConstruct;

/***
 * Bank has customers
 * <p>
 * Customers have one or more accounts
 * <p>
 * Accounts have a balance and interest
 * <p>
 * Customers can transfer money between their private accounts and make payments to other customer accounts
 * <p>
 * <p>
 * Feature List
 * <p>
 * - Register User - api and ui
 * - Sign in User - api and ui
 * - Create account - api and ui
 * - Create transfer
 **/
@SpringBootApplication
public class SpringBank extends ResourceServerConfigurerAdapter {


    public static void main(String[] args) {
        SpringApplication.run(SpringBank.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @PostConstruct
    private void postConstruct() {
        User user = new User("admin", new BCryptPasswordEncoder().encode("admin"));
        userRepository.save(user);

        UserRole userRole = new UserRole(user, "ADMIN");
        userRoleRepository.save(userRole);
    }
}
