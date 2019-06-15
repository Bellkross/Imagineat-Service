package com.bellkross.imangineat.service;

import com.bellkross.imangineat.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuService extends CrudServiceImpl<Menu, Long> {

    @Autowired
    MenuService(JpaRepository<Menu, Long> repository) {
        super(repository);
    }

}
