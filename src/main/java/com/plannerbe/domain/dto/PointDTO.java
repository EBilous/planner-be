package com.plannerbe.domain.dto;

import com.plannerbe.domain.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * DTO for {@link com.plannerbe.domain.entity.Point}
 */


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class PointDTO {
    private Long id;
    private String name;
    private String description;
    private String latitude;
    private String longitude;
    private String image;
    private List<Category> categoriesIds;
    private AddressDTO address;
}