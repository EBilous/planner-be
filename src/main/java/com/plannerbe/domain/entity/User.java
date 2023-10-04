package com.plannerbe.domain.entity;

import org.hibernate.annotations.Generated;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "person")
public class User {
    @Id()
    @GeneratedValue()
    Integer id;
    @Column(nullable = false)
    String first_name;
    @Column(nullable = false)
    String last_name;
    @Column(nullable = false, unique = true)
    String email;
    @Column(nullable = false)
    String password;
    @OneToOne(mappedBy = "id")
    Integer address_id;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    Role role_id;
    @Column
    @Generated
    Timestamp created_at;
    @Column
    @Generated
    Timestamp updated_at;
}
