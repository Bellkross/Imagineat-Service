package com.bellkross.imangineat.respository;

import com.bellkross.imangineat.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
