package com.bellkross.imangineat.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "menu_item_tag")
@Table(name = "menu_item_tag")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MenuItemTag {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "menu_item_has_tag", joinColumns = @JoinColumn(name = "menu_item_tag_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "menu_item_id", referencedColumnName = "id"))
    private Set<MenuItem> menuItems = new HashSet<>();
}
