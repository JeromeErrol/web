package com.market.web.services;

import com.market.domain.valueobjects.Image;
import com.market.domain.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

@Service
public class ImageService {

    @Autowired
    ImageRepository repository;

    @Autowired
    ImageResourceAssembler resourceAssembler;

    public Resource<Image> create(Image image) {
        return resourceAssembler.toResource(repository.save(image));
    }

    public void downloadImage(@PathVariable String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        String fileName = url.getFile();
        String destName = "./figures" + fileName.substring(fileName.lastIndexOf("/"));

        InputStream inputStream = url.openStream();
        OutputStream outputStream = new FileOutputStream(destName);

        byte[] b = new byte[2048];
        int length;

        while ((length = inputStream.read(b)) != -1) {
            outputStream.write(b, 0, length);
        }

        inputStream.close();
        outputStream.close();
    }

    public Image get(Long id) {
        return repository.findOne(id);
    }
}

