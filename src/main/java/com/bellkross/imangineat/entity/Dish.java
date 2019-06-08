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
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(name = "gr_description")
    private String gramsDescription;
    @Column(name = "cl_description")
    private String caloriesDescription;
    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "dishes", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Ingredient> ingredients = new HashSet<>();

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        ingredient.getDishes().add(this);
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
        ingredient.getDishes().remove(this);
    }
}
