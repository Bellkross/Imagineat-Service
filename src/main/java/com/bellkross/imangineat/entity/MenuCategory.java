package com.bellkross.imangineat.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "menu_category")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MenuCategory {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "category")
    private Set<Menu> menus = new HashSet<>();

    public void addMenu(Menu menu) {
        menus.add(menu);
        menu.setCategory(this);
    }

    public void removeMenu(Menu menu) {
        menus.remove(menu);
        menu.setCategory(null);
    }
}
