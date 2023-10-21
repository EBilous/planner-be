package com.plannerbe.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String latitude;
    private String longitude;
    private String image;
    @OneToOne()
    Address address;
    @ManyToMany
    @JoinTable(
        name = "point_category",
        joinColumns = {
            @JoinColumn(
                name = "point_id",
                nullable = false
            )
        },
        inverseJoinColumns = {
            @JoinColumn(
                name = "category_id",
                nullable = false
            )
        }
    )
    private List<Category> categoriesList = new ArrayList<>();
}
