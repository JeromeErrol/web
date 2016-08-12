package com.demo.web.controllers;

import com.demo.repositories.CityRepository;
import com.demo.repositories.CountryRepository;
import com.demo.domain.City;
import com.demo.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/***
 * There are two strategies for setting up relationships between entities
 * <p>
 * OneToMany and ManyToOne
 * <p>
 * So what is the difference?
 * <p>
 * In some cases its possible for one thing to belong to have multiple parents
 * <p>
 * In other cases its only possible for an entity to have a single parent.
 * <p>
 * EarthApi
 * <p>
 * /continents/{id}/countries/{id}/cities            (GET) (ALL)
 * /continents/{id}/countries/{id}/cities            (POST)
 * /continents/{id}/countries/{id}/cities/1          (GET)
 * /continents/{id}/countries/{id}/cities/1          (PUT)
 * /continents/{id}/countries/{id}/cities/1          (DELETE)
 * <p>
 * /cities                  (GET)           (Select all)
 * /cities&title={title}    (GET)           (Search)
 * /cities                  (POST)          (Create)
 * /cities/1                (GET)           (FindById)
 * /cities/1                (PUT)           (Update)
 * /cities/1                (DELETE)        (Delete)
 * <p>
 * <p>
 * <p>
 * <p>
 * /countries/{countryId}/cities    (GET)   (listing all the cities belonging to a country )
 * /countries/{countryId}/cities    (POST)  (add a city to a country)
 * <p>
 * /cities              (GET)
 * /cities/{id}         (GET)
 * /cities/{id}         (PUT)
 * /cities/{id}         (DELETE)
 * <p>
 * <p>
 * /cities/{id}/country (GET)
 * /cities/{id}/name    (GET)
 */
@RestController
@RequestMapping(value = "/countries")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Country get(@PathVariable long id) {
        return countryRepository.findOne(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Country> get() {
        List<Country> countries = new ArrayList<>();
        countryRepository.findAll().forEach(country -> countries.add(country));
        return countries;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Country create(@RequestBody Country country) {
        return countryRepository.save(country);
    }

    @RequestMapping(value = "/{id}/cities", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public City addCity(@PathVariable long id, @RequestBody City city) {
        Country country = countryRepository.findOne(id);
        city.setCountry(country);
        City savedCity = cityRepository.save(city);
        countryRepository.save(country);
        return savedCity;
    }

    @RequestMapping(value = "/{id}/cities", method = RequestMethod.GET)
    public List<City> getCities(@PathVariable long id) {
        Country country = countryRepository.findOne(id);
        return cityRepository.findAllByCountry(country);
    }
}
