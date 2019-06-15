package com.bellkross.imangineat.service;

import com.bellkross.imangineat.entity.MenuItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuItemCategoryService extends CrudServiceImpl<MenuItemCategory, String> {

    @Autowired
    MenuItemCategoryService(JpaRepository<MenuItemCategory, String> repository) {
        super(repository);
    }

}
