package com.plannerbe.domain.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Scope("prototype")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @OneToOne()
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User author;
    @OneToOne()
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @Getter
    @Column(name = "url", length = 510)
    private String url;
}

/*
    create table route
    (
        id          int auto_increment,
        title       varchar(510) not null,
    description varchar(510) null,
    url         varchar      null,
    author_id   int          null,
    constraint route_user_id_fk
    foreign key (author_id) references user (id)
    );*/
