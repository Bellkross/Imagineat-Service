package com.bellkross.imangineat.service;

import com.bellkross.imangineat.entity.RestaurantPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantPhotoService extends CrudServiceImpl<RestaurantPhoto, Long> {

    @Autowired
    RestaurantPhotoService(JpaRepository<RestaurantPhoto, Long> repository) {
        super(repository);
    }

}
