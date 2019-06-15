package com.bellkross.imangineat.service;

import com.bellkross.imangineat.entity.RestaurantRatedByUser;
import com.bellkross.imangineat.entity.RestaurantRatedByUserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantRatedByUserService extends CrudServiceImpl<RestaurantRatedByUser, RestaurantRatedByUserId> {

    @Autowired
    RestaurantRatedByUserService(JpaRepository<RestaurantRatedByUser, RestaurantRatedByUserId> repository) {
        super(repository);
    }

}
