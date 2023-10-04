package com.plannerbe.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Role {
    @Id
    @GeneratedValue
    @Column
    Long id;

    @Column(unique = true, nullable = false)
    String name;
}
