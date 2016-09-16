package com.springbank.repositories;

import com.springbank.domain.Account;
import com.springbank.domain.AccountHolder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findByOwner(AccountHolder owner);
}
