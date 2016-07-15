package com.market.domain.repositories;

import com.market.domain.valueobjects.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Float> {
}
