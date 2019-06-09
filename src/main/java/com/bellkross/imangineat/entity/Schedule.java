package com.bellkross.imangineat.entity;

import com.bellkross.imangineat.constants.DayName;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "schedule")
@Table(name = "schedule")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Schedule {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "open_time", nullable = false)
    private Timestamp openTime;
    @Column(name = "close_time", nullable = false)
    private Timestamp closeTime;
    @Enumerated(EnumType.STRING)
    @Column(name = "day_name", nullable = false)
    private DayName dayName;

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "restaurant_has_schedule", joinColumns = @JoinColumn(name = "schedule_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "restaurant_id", referencedColumnName = "id"))
    private Set<Restaurant> restaurants = new HashSet<>();

}
