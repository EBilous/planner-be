package com.plannerbe.domain.mapper;

import com.plannerbe.domain.dto.PointDTO;
import com.plannerbe.domain.entity.Point;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PointMapper {
    PointMapper INSTANCE = Mappers.getMapper( PointMapper.class );

    PointDTO toPointDto(Point point);
    Point toPointEntity(PointDTO pointDto);
}
