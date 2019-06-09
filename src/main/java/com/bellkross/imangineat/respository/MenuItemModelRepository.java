package com.bellkross.imangineat.respository;

import com.bellkross.imangineat.entity.MenuItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemModelRepository extends JpaRepository<MenuItemModel, String> {
}
