package com.market.domain.repositories;

import com.market.domain.valueobjects.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {
}
