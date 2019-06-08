package com.bellkross.imangineat.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "menu_item")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MenuItem {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "second_name")
    private String secondName;
    private String description;
    @Column(name = "price", nullable = false)
    private Integer price;
    @Column(name = "currency")
    private String currency;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_item_category_id")
    private MenuItemCategory category;
    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "menuItems", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Dish> dishes = new HashSet<>();

    public void addDish(Dish dish) {
        dishes.add(dish);
        dish.getMenuItems().add(this);
    }

    public void removeDish(Dish dish) {
        dishes.remove(dish);
        dish.getMenuItems().remove(this);
    }
}
