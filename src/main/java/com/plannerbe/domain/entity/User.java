package com.plannerbe.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "user", schema = "planner_db")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String password;
    String phone;

    @OneToOne
    @JoinColumn(name = "address_id")
    Address address;

    @ManyToMany
    @JoinTable(
        name = "user_role", schema = "planner_db",
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
    @CreationTimestamp
    Timestamp created_at;

    @Column
    @UpdateTimestamp
    Timestamp updated_at;
}
