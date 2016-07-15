package com.market.domain.repositories;

import com.market.domain.valueobjects.Category;
import com.market.domain.valueobjects.Stock;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StockRepository extends PagingAndSortingRepository<Stock, Long>, JpaSpecificationExecutor {

    List<Stock> findByCategory(Category category);
}
