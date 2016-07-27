package com.demo.domain.repositories;

import com.demo.domain.valueobjects.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Float> {
}
