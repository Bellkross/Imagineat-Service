package com.bellkross.imangineat.respository;

import com.bellkross.imangineat.entity.RestaurantTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantTagRepository extends JpaRepository<RestaurantTag, Long> {
}
