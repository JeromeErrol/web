package com.market.service.image;

import com.market.domain.Image;
import com.market.web.CategoryController;
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
