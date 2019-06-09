package com.bellkross.imangineat.respository;

import com.bellkross.imangineat.entity.RestaurantPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantPhotoRepository extends JpaRepository<RestaurantPhoto, Long> {
}
