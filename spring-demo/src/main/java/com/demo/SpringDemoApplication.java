package com.demo;

import com.demo.repositories.CountryRepository;
import com.google.common.cache.CacheBuilder;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class SpringDemoApplication extends ResourceServerConfigurerAdapter {

    // http://www.tutorialspoint.com/guava/guava_caching_utilities.htm

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

        LoadingCache<String, Employee> employeeCache =
                CacheBuilder.newBuilder()
                        .maximumSize(100) // maximum 100 records can be cached
                        .expireAfterAccess(30, TimeUnit.MINUTES) // cache will expire after 30 minutes of access
                        .build(new CacheLoader<String, Employee>(){ // build the cacheloader

                            @Override
                            public Employee load(String empId) throws Exception {
                                //make the expensive call
                                return getFromDatabase(empId);
                            }
                        });
    }


}
