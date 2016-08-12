package com.demo.repositories;

import com.demo.domain.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "countries2", path = "countries")
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
}
