package com.demo.web.services;

import com.demo.domain.valueobjects.Category;
import com.demo.domain.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private CategoryResourceAssembler resourceAssembler;

    public Resource<Category> save(Category category) {
        return resourceAssembler.toResource(repository.save(category));
    }

    public List<Resource<Category>> selectAll() {
        List<Resource<Category>> categories = new ArrayList<>();
        for (Category category : repository.findAll()) {
            categories.add(resourceAssembler.toResource(category));
        }
        return categories;
    }
}
