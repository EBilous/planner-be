package com.plannerbe.domain.mapper;

import com.plannerbe.domain.dto.RouteDTO;
import com.plannerbe.domain.entity.Route;

import org.springframework.stereotype.Component;

@Component
public class RouteMapper {

    public RouteDTO toDTO(Route route) {
        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setId(route.getId());
        routeDTO.setTitle(route.getTitle());
        routeDTO.setDescription(route.getDescription());
        routeDTO.setAuthorId(route.getAuthor().getId()); // Assuming User has a getId() method
        routeDTO.setCategoryId(route.getCategory().getId()); // Assuming Category has a getId() method
        routeDTO.setUrl(route.getUrl());
        return routeDTO;
    }

    public Route toEntity(RouteDTO routeDTO) {
        Route route = new Route();
        route.setId(routeDTO.getId());
        route.setTitle(routeDTO.getTitle());
        route.setDescription(routeDTO.getDescription());
        // You can set the User and Category entities based on the IDs if needed
        route.setUrl(routeDTO.getUrl());
        return route;
    }
}
