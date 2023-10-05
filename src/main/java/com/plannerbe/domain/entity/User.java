package com.plannerbe.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.Generated;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder(toBuilder=true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "planner_db")
@Component
@Scope("prototype")
public class User {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="first_name",nullable = false)
    String firstName;
    @Column(name ="last_name", nullable = false)
    String lastName;
    @Column(nullable = false, unique = true)
    String email;
    @Column(nullable = false)
    String password;
    @OneToOne()
    Address address_id;
    @ManyToMany
    @JoinTable(
        name = "user_role", schema = "plenner_db",
        joinColumns = {
            @JoinColumn(
                name = "user_id",
                nullable = false
            )
        },
        inverseJoinColumns = {
            @JoinColumn(
                name = "role_id",
                nullable = false
            )
        }

    )
    @JsonIgnore
    private List<Role> roleList = new ArrayList<>();
    @Column
    @Generated
    Timestamp created_at;
    @Column
    @Generated
    Timestamp updated_at;
}
