package com.plannerbe.domain.mapper;

import com.plannerbe.domain.dto.PointDTO;
import com.plannerbe.domain.entity.Point;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class PointMapper {
    public PointDTO toDTO(@NotNull Point point) {
        PointDTO dto = new PointDTO();
        dto.setId(point.getId());
        dto.setName(point.getName());
        dto.setDescription(point.getDescription());
        dto.setImage(point.getImage());
        dto.setLatitude(point.getLatitude());
        dto.setLongitude(point.getLongitude());
        dto.setCategoriesIds(point.getCategoriesList());
        return dto;
    }

    public Point toEntity(@NotNull PointDTO pointDTO) {
        Point point = new Point();
        point.setId(pointDTO.getId());
        point.setName(pointDTO.getName());
        point.setDescription(pointDTO.getDescription());
        point.setImage(pointDTO.getImage());
        point.setLatitude(pointDTO.getLatitude());
        point.setLongitude(pointDTO.getLongitude());
        return point;
    }
}
