package com.springbank.repositories;

import com.springbank.domain.AccountTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountTransactionRepository extends CrudRepository<AccountTransaction, Long> {

    List<AccountTransaction> findByProcessed(boolean processed);
}
