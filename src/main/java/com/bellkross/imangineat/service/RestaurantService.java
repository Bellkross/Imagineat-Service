package com.bellkross.imangineat.service;

import com.bellkross.imangineat.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService extends CrudServiceImpl<Restaurant, Long> {

    @Autowired
    RestaurantService(JpaRepository<Restaurant, Long> repository) {
        super(repository);
    }

}
