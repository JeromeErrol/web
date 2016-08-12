package com.demo.repositories;

import com.demo.domain.Category;
import com.demo.domain.Stock;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StockRepository extends PagingAndSortingRepository<Stock, Long>, JpaSpecificationExecutor {

    List<Stock> findByCategory(Category category);
}
