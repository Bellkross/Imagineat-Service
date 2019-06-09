package com.bellkross.imangineat.entity;

import com.bellkross.imangineat.constants.PriceRange;
import com.bellkross.imangineat.constants.Rating;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "restaurant")
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Restaurant {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String description;
    @Column(name = "phone_num", nullable = false)
    private String phoneNumber;
    @Column(name = "website_address", nullable = false)
    private String websiteAddress;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "external_rating")
    private Rating externalRating;
    @Enumerated(EnumType.STRING)
    @Column(name = "price_range")
    private PriceRange priceRange;

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "restaurants", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Menu> menus = new HashSet<>();
    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "restaurants", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<RestaurantTag> tags = new HashSet<>();
    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "restaurants", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Schedule> schedules = new HashSet<>();
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "restaurant")
    private Set<RestaurantPhoto> photos = new HashSet<>();

    public void addTag(RestaurantTag tag) {
        tags.add(tag);
        tag.getRestaurants().add(this);
    }

    public void removeTag(RestaurantTag tag) {
        tags.remove(tag);
        tag.getRestaurants().remove(this);
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
        menu.getRestaurants().add(this);
    }

    public void removeMenu(Menu menu) {
        menus.remove(menu);
        menu.getRestaurants().remove(this);
    }

    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
        schedule.getRestaurants().add(this);
    }

    public void removeMenu(Schedule schedule) {
        schedules.remove(schedule);
        schedule.getRestaurants().remove(this);
    }

    public void addPhoto(RestaurantPhoto photo) {
        photos.add(photo);
        photo.setRestaurant(this);
    }

    public void removePhoto(RestaurantPhoto photo) {
        photos.remove(photo);
        photo.setRestaurant(null);
    }
}
