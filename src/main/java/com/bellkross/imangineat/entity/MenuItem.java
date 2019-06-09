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
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "menuItem")
    private Set<MenuItemModel> models = new HashSet<>();
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "menuItem")
    private Set<MenuItemPhoto> photos = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_item_category_id")
    private MenuItemCategory category;
    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "menuItems", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<MenuItemTag> tags = new HashSet<>();
    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "menuItems", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Dish> dishes = new HashSet<>();
    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "menu_has_menu_item", joinColumns = @JoinColumn(name = "menu_item_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "id"))
    private Set<Menu> menus = new HashSet<>();

    public void addTag(MenuItemTag tag) {
        tags.add(tag);
        tag.getMenuItems().add(this);
    }

    public void removeTag(MenuItemTag tag) {
        tags.remove(tag);
        tag.getMenuItems().remove(this);
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
        dish.getMenuItems().add(this);
    }

    public void removeDish(Dish dish) {
        dishes.remove(dish);
        dish.getMenuItems().remove(this);
    }

    public void addPhoto(MenuItemPhoto photo) {
        photos.add(photo);
        photo.setMenuItem(this);
    }

    public void removePhoto(MenuItemPhoto photo) {
        photos.remove(photo);
        photo.setMenuItem(null);
    }

    public void addModel(MenuItemModel model) {
        models.add(model);
        model.setMenuItem(this);
    }

    public void removeModel(MenuItemModel model) {
        models.remove(model);
        model.setMenuItem(null);
    }
}
