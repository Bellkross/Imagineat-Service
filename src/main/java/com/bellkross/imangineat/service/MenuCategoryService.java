package com.bellkross.imangineat.service;

import com.bellkross.imangineat.entity.MenuCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuCategoryService extends CrudServiceImpl<MenuCategory, Long> {

    @Autowired
    MenuCategoryService(JpaRepository<MenuCategory, Long> repository) {
        super(repository);
    }

}
