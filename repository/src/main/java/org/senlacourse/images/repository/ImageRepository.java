package org.senlacourse.images.repository;

import org.senlacourse.images.domain.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String> {
}
