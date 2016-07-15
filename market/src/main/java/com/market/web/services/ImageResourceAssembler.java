package com.market.web.services;

import com.market.domain.valueobjects.Image;
import com.market.web.controllers.CategoryController;
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
