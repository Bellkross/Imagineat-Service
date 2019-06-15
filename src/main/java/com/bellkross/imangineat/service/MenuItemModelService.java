package com.bellkross.imangineat.service;

import com.bellkross.imangineat.entity.MenuItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuItemModelService extends CrudServiceImpl<MenuItemModel, String> {

    @Autowired
    MenuItemModelService(JpaRepository<MenuItemModel, String> repository) {
        super(repository);
    }

}
