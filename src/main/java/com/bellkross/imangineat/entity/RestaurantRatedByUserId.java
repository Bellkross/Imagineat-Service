package com.bellkross.imangineat.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRatedByUserId implements Serializable {
    private Long restaurantId;
    private Long customerId;
}
