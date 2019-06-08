package com.bellkross.imangineat.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ingredient {
    @Id
    private String title;
    @ManyToMany
    @Setter(AccessLevel.PRIVATE)
    @JoinTable(name = "dish_has_ingredient", joinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "title"), inverseJoinColumns = @JoinColumn(name = "dish_id", referencedColumnName = "id"))
    private Set<Dish> dishes = new HashSet<>();
}
