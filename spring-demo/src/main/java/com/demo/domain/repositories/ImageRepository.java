package com.demo.domain.repositories;

import com.demo.domain.valueobjects.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {
}
