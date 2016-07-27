package com.demo.web.controllers;

import com.demo.domain.repositories.CityRepository;
import com.demo.domain.repositories.CountryRepository;
import com.demo.domain.valueobjects.City;
import com.demo.domain.valueobjects.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Country> search(@PathVariable String title) {
        List<Country> countries = new ArrayList<>();
        countryRepository.findAll().forEach(country -> countries.add(country));
        return countries;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Country create(@RequestBody Country country) {
        return countryRepository.save(country);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Country addCity(@PathVariable long id, @RequestBody City city) {
        Country country = countryRepository.findOne(id);
        cityRepository.save(city);
        country.getCities().add(city);
        return countryRepository.save(country);
    }
}
