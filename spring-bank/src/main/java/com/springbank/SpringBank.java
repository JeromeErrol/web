package com.springbank;

import com.springbank.domain.Account;
import com.springbank.domain.User;
import com.springbank.domain.UserRole;
import com.springbank.repositories.AccountRepository;
import com.springbank.repositories.UserRepository;
import com.springbank.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
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

    @Autowired
    private AccountRepository accountRepository;

    @PostConstruct
    private void postConstruct() {
        User admin = new User("admin", new BCryptPasswordEncoder().encode("admin"));
        userRepository.save(admin);
        UserRole userRole = new UserRole(admin, "ADMIN");
        userRoleRepository.save(userRole);
        System.out.println("creating user admin with password " + new BCryptPasswordEncoder().encode("admin"));

        Account adminAccount = new Account(admin);
        adminAccount.setBalance(500);
        accountRepository.save(adminAccount);


        User customer = new User("foo", new BCryptPasswordEncoder().encode("bar"));
        userRepository.save(customer);
        UserRole customerUserRole = new UserRole(customer, "USER");
        userRoleRepository.save(userRole);
        System.out.println("creating user foo with password " + new BCryptPasswordEncoder().encode("bar"));

        Account customerAccount = new Account(customer);
        adminAccount.setBalance(200);
        accountRepository.save(customerAccount);
    }
}
