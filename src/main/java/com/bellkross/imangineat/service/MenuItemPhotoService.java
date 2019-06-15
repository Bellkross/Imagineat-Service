package com.bellkross.imangineat.service;

import com.bellkross.imangineat.entity.MenuItemPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuItemPhotoService extends CrudServiceImpl<MenuItemPhoto, String> {

    @Autowired
    MenuItemPhotoService(JpaRepository<MenuItemPhoto, String> repository) {
        super(repository);
    }

}
