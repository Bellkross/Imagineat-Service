package com.bellkross.imangineat.respository;

import com.bellkross.imangineat.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
