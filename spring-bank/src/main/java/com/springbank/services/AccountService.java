package com.springbank.services;

import com.springbank.domain.AccountTransaction;
import com.springbank.repositories.AccountRepository;
import com.springbank.repositories.AccountTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountTransactionRepository accountTransactionRepository;
    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountTransactionRepository accountTransactionRepository, AccountRepository accountRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
        this.accountRepository = accountRepository;
    }

    public void processAccountTransactions() {
        accountTransactionRepository.findByProcessed(false).stream().forEach(accountTransaction -> processAccountTransaction(accountTransaction));
    }
    
    private void processAccountTransaction(AccountTransaction accountTransaction) {
        if (!accountTransaction.isProcessed()) {
            System.out.println(String.format("Transferring %s from %s to %s", accountTransaction.getAmount(), accountTransaction.getSource().getId(), accountTransaction.getTarget().getId()));
            accountTransaction.process();
            accountTransactionRepository.save(accountTransaction);
            accountRepository.save(accountTransaction.getSource());
            accountRepository.save(accountTransaction.getTarget());
        }
    }
}
