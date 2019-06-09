package com.bellkross.imangineat.respository;

import com.bellkross.imangineat.entity.MenuItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemCategoryRepository extends JpaRepository<MenuItemCategory, String> {
}
