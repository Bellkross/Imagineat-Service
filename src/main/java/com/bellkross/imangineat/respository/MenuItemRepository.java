package com.bellkross.imangineat.respository;

import com.bellkross.imangineat.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
