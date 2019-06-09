package com.bellkross.imangineat.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "restaurant_rated_by_customer")
@Table(name = "restaurant_rated_by_customer")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class RestaurantRatedByUser {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private RestaurantRatedByUserId id;
    @Column(nullable = false)
    private Integer point;
    @Column(nullable = false)
    private String comment;

    public static RestaurantRatedByUser rate(User user, Integer point, String comment, Restaurant restaurant) {
        RestaurantRatedByUserId id = new RestaurantRatedByUserId(restaurant.getId(), user.getId());
        RestaurantRatedByUser restaurantRatedByUser = new RestaurantRatedByUser();
        restaurantRatedByUser.setId(id);
        restaurantRatedByUser.setPoint(point);
        restaurantRatedByUser.setComment(comment);
        return restaurantRatedByUser;
    }
}