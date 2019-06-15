package com.bellkross.imangineat.service;

import com.bellkross.imangineat.entity.RestaurantTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantTagService extends CrudServiceImpl<RestaurantTag, Long> {

    @Autowired
    RestaurantTagService(JpaRepository<RestaurantTag, Long> repository) {
        super(repository);
    }

}
