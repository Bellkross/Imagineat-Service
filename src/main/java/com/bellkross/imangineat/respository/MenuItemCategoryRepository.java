package com.bellkross.imangineat.respository;

import com.bellkross.imangineat.entity.MenuItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemCategoryRepository extends JpaRepository<MenuItemCategory, String> {
}
