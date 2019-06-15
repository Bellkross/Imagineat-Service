package com.bellkross.imangineat.service;

import com.bellkross.imangineat.entity.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuItemService extends CrudServiceImpl<MenuItem, Long> {

    @Autowired
    MenuItemService(JpaRepository<MenuItem, Long> repository) {
        super(repository);
    }

}
