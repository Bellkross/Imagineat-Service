package com.bellkross.imangineat.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "ingredient")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ingredient {
    @Id
    @EqualsAndHashCode.Include
    private String title;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Setter(AccessLevel.PRIVATE)
    @JoinTable(name = "dish_has_ingredient", joinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "title"), inverseJoinColumns = @JoinColumn(name = "dish_id", referencedColumnName = "id"))
    private Set<Dish> dishes = new HashSet<>();
}
