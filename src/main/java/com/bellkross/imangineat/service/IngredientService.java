package com.bellkross.imangineat.service;

import com.bellkross.imangineat.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredientService extends CrudServiceImpl<Ingredient, String> {

    @Autowired
    IngredientService(JpaRepository<Ingredient, String> repository) {
        super(repository);
    }

}
