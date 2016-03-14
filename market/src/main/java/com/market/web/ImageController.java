package com.market.web;

import com.market.domain.Image;
import com.market.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/images")
public class ImageController {

    @Autowired
    ImageService service;

    @RequestMapping(method = RequestMethod.POST)
    public Resource<Image> create(@RequestBody Image image) {
        return service.create(image);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{imageUrl}")
    public void downloadImage(@PathVariable String imageUrl) throws IOException {
        service.downloadImage(imageUrl);
    }
}
