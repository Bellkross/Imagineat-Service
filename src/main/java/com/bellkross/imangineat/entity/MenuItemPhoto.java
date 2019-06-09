package com.bellkross.imangineat.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "menu_item_photo")
@Table(name = "menu_item_photo")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MenuItemPhoto {
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "file_path")
    private String filePath;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;
}
