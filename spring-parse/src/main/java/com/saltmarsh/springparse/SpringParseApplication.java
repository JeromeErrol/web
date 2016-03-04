package com.saltmarsh.springparse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringParseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringParseApplication.class, args);
    }


    @PostConstruct
    public void postConstruct() {


    }
}
