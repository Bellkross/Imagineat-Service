package com.bellkross.imangineat.service;

import com.bellkross.imangineat.entity.MenuItemTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuItemTagService extends CrudServiceImpl<MenuItemTag, Long> {

    @Autowired
    MenuItemTagService(JpaRepository<MenuItemTag, Long> repository) {
        super(repository);
    }

}
