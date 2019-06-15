package com.bellkross.imangineat.respository;

import com.bellkross.imangineat.entity.RestaurantPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantPhotoRepository extends JpaRepository<RestaurantPhoto, String> {
}
