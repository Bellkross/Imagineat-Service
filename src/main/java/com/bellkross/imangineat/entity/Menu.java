package com.bellkross.imangineat.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "menu")
@Table(name = "menu")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Menu {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "menus", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<MenuItem> items = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_category_id")
    private MenuCategory category;
    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "restaurant_has_menu", joinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "restaurant_id", referencedColumnName = "id"))
    private Set<Restaurant> restaurants = new HashSet<>();

    public void addItem(MenuItem item) {
        items.add(item);
        item.getMenus().add(this);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
        item.getMenus().remove(this);
    }

}
