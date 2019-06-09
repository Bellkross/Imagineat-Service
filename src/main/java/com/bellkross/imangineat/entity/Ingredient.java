package com.bellkross.imangineat.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "ingredient")
@Table(name = "ingredient")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ingredient {
    @Id
    @EqualsAndHashCode.Include
    private String title;
    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "dish_has_ingredient", joinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "title"), inverseJoinColumns = @JoinColumn(name = "dish_id", referencedColumnName = "id"))
    private Set<Dish> dishes = new HashSet<>();
}
