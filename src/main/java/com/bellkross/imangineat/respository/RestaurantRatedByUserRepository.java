package com.bellkross.imangineat.respository;

import com.bellkross.imangineat.entity.RestaurantRatedByUser;
import com.bellkross.imangineat.entity.RestaurantRatedByUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRatedByUserRepository extends JpaRepository<RestaurantRatedByUser, RestaurantRatedByUserId> {
}
