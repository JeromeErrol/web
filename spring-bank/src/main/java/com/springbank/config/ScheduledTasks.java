package com.springbank.config;

import com.springbank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableAsync
@EnableScheduling
public class ScheduledTasks {

    private AccountService accountService;

    @Autowired
    public ScheduledTasks(AccountService accountService) {
        this.accountService = accountService;
    }

    @Scheduled(fixedDelay = 10000)
    @Async
    public void processAccountTransactions() {
        accountService.processAccountTransactions();
    }
}
