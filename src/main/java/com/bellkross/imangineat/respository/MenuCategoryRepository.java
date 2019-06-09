package com.bellkross.imangineat.respository;

import com.bellkross.imangineat.entity.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Long> {
}
