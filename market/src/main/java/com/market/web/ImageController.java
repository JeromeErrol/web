package com.market.web;

import com.market.domain.Image;
import com.market.service.image.ImageService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

@RestController
@RequestMapping(value = "/images")
public class ImageController {

    @Autowired
    ImageService service;

    @RequestMapping(method = RequestMethod.POST, value = "/{imageUrl}")
    public void downloadImage(@PathVariable String imageUrl) throws IOException {
        service.downloadImage(imageUrl);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Resource<Image> upload(@RequestBody String base61Encoded) throws IOException {
        Image image = new Image(base61Encoded);
        return service.create(image);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Image select(@PathVariable Long id) throws IOException {
        return service.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/src/{id}")
    public String selectSrc(@PathVariable Long id) throws IOException {
        return service.get(id).getBase64();
    }
}
