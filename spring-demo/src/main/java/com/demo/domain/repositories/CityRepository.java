package com.demo.domain.repositories;

import com.demo.domain.valueobjects.City;
import com.demo.domain.valueobjects.Country;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CityRepository extends PagingAndSortingRepository<City, Long>, JpaSpecificationExecutor {

    @Query
    List<City> findAllByCountry(Country country);
}
