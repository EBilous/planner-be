package com.plannerbe.domain.service;

import com.plannerbe.domain.dto.PointDTO;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PointService {
    PointDTO createPoint(PointDTO pointDto);
    Optional<PointDTO> getPointById(Long id);
    Optional<PointDTO> getPointByName(String name);
    List<PointDTO> getPointByCity(String city);
}
