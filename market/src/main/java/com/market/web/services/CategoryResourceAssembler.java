package com.market.web.services;

import com.market.domain.valueobjects.Category;
import com.market.web.controllers.CategoryController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class CategoryResourceAssembler implements ResourceAssembler<Category, Resource<Category>> {
    @Override
    public Resource<Category> toResource(Category category) {
        Resource<Category> resource = new Resource<Category>(category);
        resource.add(linkTo(CategoryController.class).slash(category.getId()).withSelfRel());
        return resource;
    }
}
