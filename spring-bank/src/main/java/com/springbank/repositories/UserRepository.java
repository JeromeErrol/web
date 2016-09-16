package com.springbank.repositories;

import com.springbank.domain.AccountHolder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<AccountHolder, Long> {
    AccountHolder findByUsername(String username);
}
