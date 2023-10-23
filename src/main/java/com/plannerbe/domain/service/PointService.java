package com.plannerbe.domain.service;

import com.plannerbe.domain.dto.PointDTO;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PointService {
    @Transactional PointDTO createPoint(PointDTO pointDto);
    @Transactional(readOnly = true) Optional<PointDTO> getPointById(Long id);
    @Transactional(readOnly = true) Optional<PointDTO> getPointByName(String name);
    @Transactional(readOnly = true) List<PointDTO> getPointByCity(String city);
}
