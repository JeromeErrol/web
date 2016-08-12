package com.demo;

import com.demo.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class SpringDemoApplication extends ResourceServerConfigurerAdapter {

    @Autowired
    private CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/countries/**").authorizeRequests().anyRequest().authenticated();
    }

    @PostConstruct
    public void postConstruct(){
        countryRepository.findAll().forEach(country -> System.out.println(country.getTitle()));
    }
}
