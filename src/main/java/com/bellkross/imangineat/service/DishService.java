package com.bellkross.imangineat.service;

import com.bellkross.imangineat.entity.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DishService extends CrudServiceImpl<Dish, Long> {

    @Autowired
    DishService(JpaRepository<Dish, Long> repository) {
        super(repository);
    }

}
