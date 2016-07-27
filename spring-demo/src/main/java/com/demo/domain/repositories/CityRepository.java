package com.demo.domain.repositories;

import com.demo.domain.valueobjects.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {

}
