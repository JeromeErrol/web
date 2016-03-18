package com.market.service.image;

import com.market.domain.Image;
import com.market.domain.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Base64;

@Service
public class ImageService {

    @Autowired
    private ImageRepository repository;

    @Autowired
    private ImageResourceAssembler resourceAssembler;

    public Resource<Image> create(Image image) {
        return resourceAssembler.toResource(repository.save(image));
    }

    public Image get(Long id){
        return repository.findOne(id);
    }

    public Image save(Image image){
        byte[] bytes = Base64.getMimeEncoder().encode(image.getBase64().getBytes());
        image.setBytes(bytes);
        return repository.save(image);
    }
}

