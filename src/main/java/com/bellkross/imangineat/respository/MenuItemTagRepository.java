package com.bellkross.imangineat.respository;

import com.bellkross.imangineat.entity.MenuItemTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemTagRepository extends JpaRepository<MenuItemTag, Long> {
}
