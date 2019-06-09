package com.bellkross.imangineat.respository;

import com.bellkross.imangineat.entity.MenuItemPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemPhotoRepository extends JpaRepository<MenuItemPhoto, String> {
}
