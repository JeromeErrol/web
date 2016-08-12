package com.demo.web.services;

import com.demo.domain.Image;
import com.demo.web.controllers.CategoryController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class ImageResourceAssembler implements ResourceAssembler<Image, Resource<Image>> {

    @Override
    public Resource<Image> toResource(Image image) {
        Resource<Image> resource = new Resource<Image>(image);
        resource.add(linkTo(CategoryController.class).slash(image.getId()).withSelfRel());
        return resource;
    }
}
