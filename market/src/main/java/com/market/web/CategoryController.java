package com.market.web;

import com.market.domain.Category;
import com.market.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    CategoryService service;

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Resource<Category> create(@RequestBody Category category) {
        return service.save(category);
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @RequestMapping(method = RequestMethod.GET)
    public List<Resource<Category>> select(){
        return service.selectAll();
    }
}
