package com.springbank.repositories;

import com.springbank.domain.AccountTransaction;
import org.springframework.data.repository.CrudRepository;

public interface AccountTransactionRepository extends CrudRepository<AccountTransaction, Long> {
}
