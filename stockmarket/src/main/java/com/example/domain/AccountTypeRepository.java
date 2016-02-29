package com.example.domain;

import org.springframework.data.repository.CrudRepository;

public interface AccountTypeRepository extends CrudRepository<AccountType, Long> {

    AccountType findByName(String name);
}
