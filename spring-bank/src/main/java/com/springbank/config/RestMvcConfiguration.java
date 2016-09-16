package com.springbank.config;

import com.springbank.domain.Account;
import com.springbank.domain.AccountHolder;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
@EnableJpaRepositories(basePackages = {"com.springbank.repositories"})
public class RestMvcConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.setBasePath("/");
        config.exposeIdsFor(Account.class, AccountHolder.class);
    }
}
