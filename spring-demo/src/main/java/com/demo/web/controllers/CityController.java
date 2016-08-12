package com.demo.web.controllers;

import com.demo.repositories.CityRepository;
import com.demo.specifications.CitySpecification;
import com.demo.domain.City;
import com.demo.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<City> getAll() {
        List<City> cities = new ArrayList<>();
        cityRepository.findAll().forEach(city -> cities.add(city));
        return cities;
    }

    @RequestMapping(method = RequestMethod.GET, value = "name={name}")
    @ResponseStatus(HttpStatus.OK)
    public List<City> search(@RequestParam("name") String name) {
        return cityRepository.findAll(new CitySpecification(name));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public City get(@PathVariable long id) {
        return cityRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public City save(@RequestBody City city) {
        return cityRepository.save(city);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void save(@PathVariable long id) {
        cityRepository.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/country")
    @ResponseStatus(HttpStatus.OK)
    public Country getCountry(@PathVariable long id) {
        return cityRepository.findOne(id).getCountry();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/name")
    @ResponseStatus(HttpStatus.OK)
    public String getTitle(@PathVariable long id) {
        return cityRepository.findOne(id).getTitle();
    }
}
