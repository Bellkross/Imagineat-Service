package com.bellkross.imangineat.respository;

import com.bellkross.imangineat.entity.RestaurantRatedByUser;
import com.bellkross.imangineat.entity.RestaurantRatedByUserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRatedByUserRepository extends JpaRepository<RestaurantRatedByUser, RestaurantRatedByUserId> {
}
