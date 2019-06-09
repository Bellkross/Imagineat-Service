package com.bellkross.imangineat.respository;

import com.bellkross.imangineat.entity.MenuItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemModelRepository extends JpaRepository<MenuItemModel, String> {
}
