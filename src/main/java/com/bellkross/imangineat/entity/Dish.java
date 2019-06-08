package com.bellkross.imangineat.entity;

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
    @ManyToMany(mappedBy = "dishes")
    private Set<Ingredient> ingredients = new HashSet<>();
}
