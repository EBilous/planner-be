package com.plannerbe.domain.dto;

import com.plannerbe.domain.entity.Point;

import lombok.*;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RouteDTO {
    private Long id;
    private String title;
    private String description;
    private Long authorId; // Instead of the User entity, we use the author's ID
    private Long categoryId; // Instead of the Category entity, we use the category's ID
    private String url;
    private Set<Point> routePoints;
}