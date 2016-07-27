package com.demo.domain.repositories;

import com.demo.domain.valueobjects.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
}
