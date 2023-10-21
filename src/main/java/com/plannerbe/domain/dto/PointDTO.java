package com.plannerbe.domain.dto;

import com.plannerbe.domain.entity.Category;

import lombok.Builder;

import java.util.List;

/**
 * DTO for {@link com.plannerbe.domain.entity.Point}
 */


@Builder
public record PointDTO(){
    static Long id;
    static String name;
    static String description;
    static String latitude;
    static String longitude;
    static String image;
    static List<Category> categoryIds;
}