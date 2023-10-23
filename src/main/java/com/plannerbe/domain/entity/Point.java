package com.plannerbe.domain.entity;

import org.jetbrains.annotations.NotNull;

import jakarta.persistence.CascadeType;
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
    @NotNull
    private String name;
    private String description;
    private String latitude;
    private String longitude;
    private String image;

    public String getCountry() {
        return address.getCountry();
    }

    public String getCity() {
        return address.getCity();
    }

    public String getStreet() {
        return address.getStreet();
    }

    public String getBuildingNumber() {
        return address.getBuildingNumber();
    }

    public String getPhone() {
        return address.getPhone();
    }

    public void setCountry(String country) {
        address.setCountry(country);
    }

    public void setCity(String city) {
        address.setCity(city);
    }

    public void setStreet(String street) {
        address.setStreet(street);
    }

    public void setBuildingNumber(String buildingNumber) {
        address.setBuildingNumber(buildingNumber);
    }

    public void setPhone(String phone) {
        address.setPhone(phone);
    }

    @OneToOne(cascade=CascadeType.ALL)
    Address address;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
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
