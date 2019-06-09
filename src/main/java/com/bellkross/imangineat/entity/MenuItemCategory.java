package com.bellkross.imangineat.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "menu_item_category")
@Table(name = "menu_item_category")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MenuItemCategory {
    @Id
    @EqualsAndHashCode.Include
    private String title;
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "category")
    private Set<MenuItem> items = new HashSet<>();

    public void addItem(MenuItem item) {
        items.add(item);
        item.setCategory(this);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
        item.setCategory(null);
    }
}
