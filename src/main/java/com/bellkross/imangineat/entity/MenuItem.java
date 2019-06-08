package com.bellkross.imangineat.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
}
