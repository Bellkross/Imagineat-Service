package com.bellkross.imangineat.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "restaurant_tag")
@Table(name = "restaurant_tag")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RestaurantTag {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "restaurant_has_tag", joinColumns = @JoinColumn(name = "restaurant_tag_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "restaurant_id", referencedColumnName = "id"))
    private Set<Restaurant> restaurants = new HashSet<>();
}