package com.demo.repositories;

import com.demo.domain.City;
import com.demo.domain.Country;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CityRepository extends PagingAndSortingRepository<City, Long>, JpaSpecificationExecutor {

    @Query
    List<City> findAllByCountry(Country country);
}
